package fr.anatom3000.gwwhit.materials.umaboz;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class UmabozBlock extends Block {
public UmabozBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.974877379219731f,2.7777035087216837f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).luminance(4));}

}