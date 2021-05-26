package fr.anatom3000.gwwhit.materials.asymcof;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class AsymcofOre extends Block {
public AsymcofOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.2811016371460808f,2.154640712175668f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).luminance(7));}

}