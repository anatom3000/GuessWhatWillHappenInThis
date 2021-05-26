package fr.anatom3000.gwwhit.materials.baqi;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class BaqiOre extends Block {
public BaqiOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.7430235826234375f,1.10769685313067f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}