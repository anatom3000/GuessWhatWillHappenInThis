package fr.anatom3000.gwwhit.materials.izymam;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IzymamOre extends Block {
public IzymamOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.73278793933846f,1.0817060508805998f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}