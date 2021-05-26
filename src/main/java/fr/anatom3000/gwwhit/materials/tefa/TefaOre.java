package fr.anatom3000.gwwhit.materials.tefa;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class TefaOre extends Block {
public TefaOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.6420650822213894f,1.56302812285616f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}