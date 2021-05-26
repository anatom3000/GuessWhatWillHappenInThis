package fr.anatom3000.gwwhit.materials.fydif;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class FydifOre extends Block {
public FydifOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.6749089205557137f,2.8845978699148587f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}