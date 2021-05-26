package fr.anatom3000.gwwhit.materials.amader;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class AmaderBlock extends Block {
public AmaderBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.0325704501380644f,3.013930612738863f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}