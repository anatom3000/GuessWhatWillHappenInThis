package fr.anatom3000.gwwhit.materials.jipna;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class JipnaOre extends Block {
public JipnaOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.0073136953248487f,4.0021043735890895f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}