package fr.anatom3000.gwwhit.materials.tushih;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class TushihOre extends Block {
public TushihOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.7391053259344154f,4.175071912502748f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}