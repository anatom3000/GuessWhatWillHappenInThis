package fr.anatom3000.gwwhit.materials.gigyh;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class GigyhBlock extends Block {
public GigyhBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.514542120625487f,4.762194860120045f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}