package fr.anatom3000.gwwhit.materials.suwow;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class SuwowOre extends Block {
public SuwowOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.5441362138762518f,4.334463911378237f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}