package fr.anatom3000.gwwhit.materials.ohyxfu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class OhyxfuOre extends Block {
public OhyxfuOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.5797628151701555f,1.7304155122687859f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}