package fr.anatom3000.gwwhit.materials.lywyg;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class LywygOre extends Block {
public LywygOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.59928814427294f,4.1831631822680775f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}