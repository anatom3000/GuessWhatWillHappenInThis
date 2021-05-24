package fr.anatom3000.gwwhit.materials.pecced;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.BlockView;
public class PeccedOre extends Block {
public PeccedOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.846165200079945f,1.5715991774714961f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

@Override
public void onEntityLand(BlockView world, Entity entity) {
if (!entity.isSneaking() && !entity.isFireImmune()) {
entity.damage(DamageSource.HOT_FLOOR, 1f);
}
}
}