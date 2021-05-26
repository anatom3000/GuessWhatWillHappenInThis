package fr.anatom3000.gwwhit.materials.ebeqir;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class EbeqirOre extends Block {
public EbeqirOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.814845340756406f,3.577373239355208f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).luminance(14));}

}