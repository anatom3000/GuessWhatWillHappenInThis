package fr.anatom3000.gwwhit.materials.aqyqyf;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class AqyqyfBlock extends Block {
public AqyqyfBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.714998321129406f,3.402009140837683f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}