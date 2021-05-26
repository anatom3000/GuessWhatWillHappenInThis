package fr.anatom3000.gwwhit.materials.renu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class RenuBlock extends Block {
public RenuBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.3111354353630866f,2.8778156416473606f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).slipperiness(0.8466700348669063f));}

}