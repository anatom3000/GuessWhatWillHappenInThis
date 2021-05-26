package fr.anatom3000.gwwhit.materials.nafxa;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class NafxaOre extends Block {
public NafxaOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.4237191032727528f,1.6917404711542843f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}