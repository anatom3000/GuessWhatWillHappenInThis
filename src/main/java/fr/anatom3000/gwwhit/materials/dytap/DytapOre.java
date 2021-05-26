package fr.anatom3000.gwwhit.materials.dytap;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class DytapOre extends Block {
public DytapOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.999940103251278f,3.6295528662994885f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}