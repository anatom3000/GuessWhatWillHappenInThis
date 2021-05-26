package fr.anatom3000.gwwhit.materials.tetus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class TetusBlock extends Block {
public TetusBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.941886912087864f,2.9203945493438335f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.9215555875220989f));}

}