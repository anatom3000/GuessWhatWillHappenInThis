package fr.anatom3000.gwwhit.materials.ratfyf;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class RatfyfOre extends Block {
public RatfyfOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.950570244488065f,1.0061783268193087f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}