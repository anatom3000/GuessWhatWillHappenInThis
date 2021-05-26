package fr.anatom3000.gwwhit.materials.ryqo;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;
public class RyqoOre extends Block {
public RyqoOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.4699934492481965f,4.715055685173315f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

@Override
public void onEntityLand(BlockView world, Entity entity) {
if (!entity.isSneaking() && !entity.isFireImmune()) {
entity.damage(DamageSource.HOT_FLOOR, 1f);
}
}
}