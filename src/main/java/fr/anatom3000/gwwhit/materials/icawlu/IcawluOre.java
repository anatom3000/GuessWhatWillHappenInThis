package fr.anatom3000.gwwhit.materials.icawlu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IcawluOre extends Block {
public IcawluOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.5862001393079908f,4.155325354252807f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}