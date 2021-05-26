package fr.anatom3000.gwwhit.materials.kigys;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class KigysOre extends Block {
public KigysOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.8626982875521447f,1.526305296924992f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}