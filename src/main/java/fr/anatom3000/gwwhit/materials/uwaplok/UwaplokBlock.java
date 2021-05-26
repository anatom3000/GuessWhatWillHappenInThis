package fr.anatom3000.gwwhit.materials.uwaplok;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class UwaplokBlock extends Block {
    public UwaplokBlock() {
        super(FabricBlockSettings.of(Material.METAL).strength(4.025290155354224f, 2.0997287501830986f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        if (!entity.isSneaking() && !entity.isFireImmune()) {
            entity.damage(DamageSource.HOT_FLOOR, 1f);
        }
    }
}