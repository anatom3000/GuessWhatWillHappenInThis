package fr.anatom3000.gwwhit.materials.obohylp;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class ObohylpBlock extends Block {
public ObohylpBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.5004622224738062f,2.398680958661891f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}