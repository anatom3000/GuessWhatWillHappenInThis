package fr.anatom3000.gwwhit.item;

import javax.annotation.Nullable;

import fr.anatom3000.gwwhit.entity.projectile.SentientArrow;
import fr.anatom3000.gwwhit.util.ProjectileHelper;
import fr.anatom3000.gwwhit.util.ProjectileHelper.ArrowOptions;
import fr.anatom3000.gwwhit.util.ProjectileHelper.ArrowType;
import fr.anatom3000.gwwhit.util.ProjectileHelper.ShootContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity.PickupPermission;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NoscopeItem extends Item {

    public NoscopeItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
        	// EVERYTHING ABOVE YOUR NECK IS GONNA BE A FINE RED MIST
			summonAimbotArrow(user.getStackInHand(hand), (ServerPlayerEntity) user);
        }
        return TypedActionResult.consume(itemStack);
    }
    
    public boolean summonAimbotArrow(ItemStack stack, ServerPlayerEntity player) {
		if (hasTrackedArrow(stack)) {
			SentientArrow arrow = getTrackedArrow(stack, player.world);
			if (arrow == null) resetTrackedArrow(stack);
			else {
				sentientArrowControl(getTrackedArrow(stack, player.world), player);
				coolDown(player, stack.getItem(), 15);
				return true;
			}
		}
		
		SentientArrow arrow = (SentientArrow) ProjectileHelper.shootArrow(1, ArrowType.SENTIENT,
				new ShootContext(player.world, player),
				new ArrowOptions(1, 1, 0, (byte)0, false, PickupPermission.DISALLOWED)).get(0);
		changeTrackedArrow(stack, arrow);
		coolDown(player, stack.getItem(), 15);
		return true;
    }
	
	public boolean sentientArrowControl(SentientArrow arrow, ServerPlayerEntity player) {
		// try redirecting the arrow
		boolean foundTarget = arrow.attemptManualRetarget();
		return foundTarget;
	}
    
    public static void coolDown(PlayerEntity player, Item item, int ticks) {
		player.getItemCooldownManager().set(item, ticks);
	}
    
    public static final String TAG_ARROWTRACKER = "TrackedAimbotArrow";
    
	public boolean hasTrackedArrow(ItemStack stack) {
		return getNBTInt(stack, TAG_ARROWTRACKER, -1) != -1;
	}
	
	public void changeTrackedArrow(ItemStack stack, SentientArrow arrow) {
		setNBTInt(stack, TAG_ARROWTRACKER, arrow.getId());
	}
	
	public void resetTrackedArrow(ItemStack stack) {
		setNBTInt(stack, TAG_ARROWTRACKER, -1);
	}
	
	public static int getNBTInt(ItemStack stack, String tag, int defaultExpected) {
		return verifyExistance(stack, tag) ? stack.getOrCreateNbt().getInt(tag) : defaultExpected;
	}
	public static void setNBTInt(ItemStack stack, String tag, int i) {
		stack.getOrCreateNbt().putInt(tag, i);
	}
	public static boolean verifyExistance(ItemStack stack, String tag) {
		return !stack.isEmpty() && stack.hasNbt() && stack.getOrCreateNbt().contains(tag);
	}
	
	@Nullable
	public SentientArrow getTrackedArrow(ItemStack stack, World level) {
		Entity tracked = level.getEntityById(getNBTInt(stack, TAG_ARROWTRACKER, -1));
		if (tracked != null && tracked instanceof SentientArrow arrow) {
			return arrow;
		}
		return null;
	}
}
