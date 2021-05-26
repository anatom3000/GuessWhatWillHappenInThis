package fr.anatom3000.gwwhit.materials.zawuf;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class ZawufOre extends Block {
public ZawufOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.340466373211538f,2.952277851046418f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}