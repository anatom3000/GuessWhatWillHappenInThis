package fr.anatom3000.gwwhit.materials.hoke;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.BlockView;
public class HokeBlock extends Block {
public HokeBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.3494904545281035f,2.852101928973192f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

@Override
public void onEntityLand(BlockView world, Entity entity) {
if (!entity.isSneaking() && !entity.isFireImmune()) {
entity.damage(DamageSource.HOT_FLOOR, 1f);
}
}
}