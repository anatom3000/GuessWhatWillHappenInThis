package fr.anatom3000.gwwhit.materials.lisluq;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;
public class LisluqBlock extends Block {
public LisluqBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.593895275317018f,1.947157825576975f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

@Override
public void onEntityLand(BlockView world, Entity entity) {
if (!entity.isSneaking() && !entity.isFireImmune()) {
entity.damage(DamageSource.HOT_FLOOR, 1f);
}
}
}