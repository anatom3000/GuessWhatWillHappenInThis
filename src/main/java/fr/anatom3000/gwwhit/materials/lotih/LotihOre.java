package fr.anatom3000.gwwhit.materials.lotih;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class LotihOre extends Block {
public LotihOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.9635176449072658f,2.425915213582175f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).luminance(1));}

}