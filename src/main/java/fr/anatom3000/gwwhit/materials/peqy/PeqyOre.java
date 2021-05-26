package fr.anatom3000.gwwhit.materials.peqy;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class PeqyOre extends Block {
public PeqyOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.0717287437950995f,4.740894063711734f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}