package fr.anatom3000.gwwhit.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
            ArrowItem arrowItem = (ArrowItem) Items.ARROW;
            PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, new ItemStack(arrowItem), user);
            persistentProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
            persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            world.spawnEntity(persistentProjectileEntity);
        }
        return TypedActionResult.consume(itemStack);
    }

}
