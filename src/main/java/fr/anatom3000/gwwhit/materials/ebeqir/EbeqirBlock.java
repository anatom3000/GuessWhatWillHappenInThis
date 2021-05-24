package fr.anatom3000.gwwhit.materials.ebeqir;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class EbeqirBlock extends Block {
public EbeqirBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.0200575717385765f,4.09310446844129f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}