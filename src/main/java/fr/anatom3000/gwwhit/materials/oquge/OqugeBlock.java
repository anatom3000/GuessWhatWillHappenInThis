package fr.anatom3000.gwwhit.materials.oquge;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class OqugeBlock extends Block {
public OqugeBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.6079647262184853f,2.6323698050685547f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).slipperiness(0.9918251559219082f));}

}