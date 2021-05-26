package fr.anatom3000.gwwhit.materials.ikaqajc;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IkaqajcOre extends Block {
public IkaqajcOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.018616076545011f,1.9324388800180428f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}