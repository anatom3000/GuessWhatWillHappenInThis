package fr.anatom3000.gwwhit.materials.giry;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class GiryOre extends Block {
public GiryOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.5787943127478266f,1.815625046045092f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}