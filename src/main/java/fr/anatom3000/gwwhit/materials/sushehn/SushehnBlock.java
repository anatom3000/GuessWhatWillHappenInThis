package fr.anatom3000.gwwhit.materials.sushehn;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class SushehnBlock extends Block {
public SushehnBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.974011037506797f,4.308521603054777f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}