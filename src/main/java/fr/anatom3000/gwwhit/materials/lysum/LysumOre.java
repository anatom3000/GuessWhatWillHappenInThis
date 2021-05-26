package fr.anatom3000.gwwhit.materials.lysum;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class LysumOre extends Block {
public LysumOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.3303088393458493f,3.5878142370699844f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}