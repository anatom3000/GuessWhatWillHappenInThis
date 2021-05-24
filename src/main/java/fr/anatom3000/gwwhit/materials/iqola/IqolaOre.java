package fr.anatom3000.gwwhit.materials.iqola;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class IqolaOre extends Block {
public IqolaOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.2267731278994045f,2.1412125703706155f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).luminance(3));}

}