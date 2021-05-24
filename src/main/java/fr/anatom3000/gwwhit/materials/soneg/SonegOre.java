package fr.anatom3000.gwwhit.materials.soneg;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class SonegOre extends Block {
public SonegOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.5540959459161985f,3.7316446948963162f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}