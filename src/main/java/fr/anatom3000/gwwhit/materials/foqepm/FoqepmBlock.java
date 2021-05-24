package fr.anatom3000.gwwhit.materials.foqepm;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class FoqepmBlock extends Block {
public FoqepmBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.881014037863231f,2.9255306535891106f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}