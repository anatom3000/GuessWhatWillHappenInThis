package fr.anatom3000.gwwhit.materials.exuzi;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class ExuziOre extends Block {
public ExuziOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.236883250592108f,2.9149704952957434f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}