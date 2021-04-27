package fr.anatom3000.gwwhit.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TransdimensionalLensItem extends Item {

    public TransdimensionalLensItem(FabricItemSettings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);
        ItemStack stack = player.getStackInHand(hand);
        HitResult result = player.raycast(512, 0.0F, false);
        if (result.getType() == HitResult.Type.BLOCK) {
            Vec3d pos = result.getPos();
            player.teleport(pos.x, pos.y + 1.0D, pos.z);
            return TypedActionResult.consume(stack);
        }
        return TypedActionResult.fail(stack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 10;
    }

}
