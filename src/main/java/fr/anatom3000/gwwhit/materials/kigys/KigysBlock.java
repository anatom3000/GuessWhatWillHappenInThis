package fr.anatom3000.gwwhit.materials.kigys;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class KigysBlock extends Block {
public KigysBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.6722841564476028f,2.7251890877075384f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}