package fr.anatom3000.gwwhit.materials.opomfam;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class OpomfamBlock extends Block {
public OpomfamBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.9637485785869853f,3.445130065905783f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}