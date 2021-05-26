package fr.anatom3000.gwwhit.materials.tefa;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class TefaBlock extends Block {
public TefaBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.081838582236901f,3.0932909786732807f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}