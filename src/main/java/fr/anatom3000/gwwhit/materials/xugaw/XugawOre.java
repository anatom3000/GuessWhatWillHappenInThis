package fr.anatom3000.gwwhit.materials.xugaw;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class XugawOre extends Block {
public XugawOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.461587851565492f,1.1769926659452317f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}