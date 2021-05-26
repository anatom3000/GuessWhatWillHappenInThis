package fr.anatom3000.gwwhit.materials.opomfam;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class OpomfamOre extends Block {
public OpomfamOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.37022927511029f,3.238710326358524f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}