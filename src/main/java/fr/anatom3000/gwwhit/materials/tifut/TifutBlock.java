package fr.anatom3000.gwwhit.materials.tifut;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class TifutBlock extends Block {
public TifutBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.4620588000155585f,4.675500380358953f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}