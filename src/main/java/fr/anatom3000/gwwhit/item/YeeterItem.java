package fr.anatom3000.gwwhit.item;

import fr.anatom3000.gwwhit.CustomItemGroups;
import fr.anatom3000.gwwhit.config.ConfigManager;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class YeeterItem extends ToolItem {
    public YeeterItem() {
        super(
            ToolMaterials.IRON,
            new FabricItemSettings()
                .group(CustomItemGroups.GWWHIT_GROUP)
                .rarity(Rarity.RARE)
                .maxDamage( 1001 )
        );
    }

    @Override
    public TypedActionResult<ItemStack> use( World world, PlayerEntity user, Hand hand ) {
        user.addVelocity(
            user.getRotationVector().x * ( ConfigManager.getActiveConfig().gameplay.items.yeeterPowerMultiplier * .9 ),
            user.getRotationVector().y * ( ConfigManager.getActiveConfig().gameplay.items.yeeterPowerMultiplier * .9 ),
            user.getRotationVector().z * ( ConfigManager.getActiveConfig().gameplay.items.yeeterPowerMultiplier * .9 )
        );
        user.velocityDirty = true;
        var stack = super.use(world, user, hand);
        stack.getValue().damage( 1, user, player -> player.sendEquipmentBreakStatus( EquipmentSlot.MAINHAND ) );
        return stack;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.gwwhit.yeeter.tooltip.0") );
        tooltip.add( new TranslatableText("item.gwwhit.yeeter.tooltip.1") );
        super.appendTooltip(stack, world, tooltip, context);
    }
}
