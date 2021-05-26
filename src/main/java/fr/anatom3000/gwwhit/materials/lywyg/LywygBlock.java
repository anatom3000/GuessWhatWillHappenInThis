package fr.anatom3000.gwwhit.materials.lywyg;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class LywygBlock extends Block {
public LywygBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.750797031209085f,1.5024434389763544f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}