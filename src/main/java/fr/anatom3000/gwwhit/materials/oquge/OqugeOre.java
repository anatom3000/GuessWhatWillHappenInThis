package fr.anatom3000.gwwhit.materials.oquge;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class OqugeOre extends Block {
public OqugeOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.021755368926826f,4.382757633251064f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}