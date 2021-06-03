package fr.anatom3000.gwwhit.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class CosmicEraserItem extends Item {

    public CosmicEraserItem(FabricItemSettings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        context.getWorld().setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof PlayerEntity) {
            entity.kill();
        } else {
            entity.remove(Entity.RemovalReason.DISCARDED);
        }
        return ActionResult.SUCCESS;
    }

}
