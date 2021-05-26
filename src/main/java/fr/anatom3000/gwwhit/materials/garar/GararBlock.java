package fr.anatom3000.gwwhit.materials.garar;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class GararBlock extends Block {
public GararBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.6738445167333618f,1.0845050158167724f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}