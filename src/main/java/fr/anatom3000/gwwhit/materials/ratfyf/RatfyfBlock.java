package fr.anatom3000.gwwhit.materials.ratfyf;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class RatfyfBlock extends Block {
public RatfyfBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.1292234054993155f,2.4760845755496264f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}