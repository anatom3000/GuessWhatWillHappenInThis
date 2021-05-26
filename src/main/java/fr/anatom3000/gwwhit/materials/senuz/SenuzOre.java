package fr.anatom3000.gwwhit.materials.senuz;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class SenuzOre extends Block {
public SenuzOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.9219375389445275f,4.0401593593869265f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}