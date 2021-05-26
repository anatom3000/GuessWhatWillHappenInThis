package fr.anatom3000.gwwhit.materials.gycu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class GycuOre extends Block {
public GycuOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.6600150340942745f,4.085745083863464f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}