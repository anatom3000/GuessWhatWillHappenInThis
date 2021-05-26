package fr.anatom3000.gwwhit.materials.tifut;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class TifutOre extends Block {
public TifutOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.8208261943478092f,4.715541266632633f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}