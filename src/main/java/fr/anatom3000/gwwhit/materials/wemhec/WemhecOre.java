package fr.anatom3000.gwwhit.materials.wemhec;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class WemhecOre extends Block {
public WemhecOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.8977757298471705f,3.2981670557700973f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}