package fr.anatom3000.gwwhit.materials.uwalusq;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class UwalusqBlock extends Block {
public UwalusqBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.3473145044352015f,2.891956251751754f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}