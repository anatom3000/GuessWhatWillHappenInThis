package fr.anatom3000.gwwhit.materials.mafab;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class MafabBlock extends Block {
public MafabBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.489282987438932f,4.288498110418534f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}