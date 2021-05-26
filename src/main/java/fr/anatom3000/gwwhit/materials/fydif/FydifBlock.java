package fr.anatom3000.gwwhit.materials.fydif;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class FydifBlock extends Block {
public FydifBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.3060341567094085f,2.6318259882365216f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}