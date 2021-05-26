package fr.anatom3000.gwwhit.materials.exuzi;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class ExuziBlock extends Block {
public ExuziBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.7347668944398564f,2.251161755292984f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}