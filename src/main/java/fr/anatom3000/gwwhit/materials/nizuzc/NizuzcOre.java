package fr.anatom3000.gwwhit.materials.nizuzc;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class NizuzcOre extends Block {
public NizuzcOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.3789682704694535f,3.7907699486664597f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}