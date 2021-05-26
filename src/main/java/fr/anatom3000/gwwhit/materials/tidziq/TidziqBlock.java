package fr.anatom3000.gwwhit.materials.tidziq;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class TidziqBlock extends Block {
public TidziqBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.578756144788023f,2.3471119683784356f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}