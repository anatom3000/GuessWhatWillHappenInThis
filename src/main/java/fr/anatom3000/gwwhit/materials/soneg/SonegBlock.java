package fr.anatom3000.gwwhit.materials.soneg;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class SonegBlock extends Block {
public SonegBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.893660516120522f,1.9490018076857392f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}