package fr.anatom3000.gwwhit.materials.silo;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class SiloBlock extends Block {
public SiloBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.458043006073042f,1.0073381983237741f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).luminance(6));}

}