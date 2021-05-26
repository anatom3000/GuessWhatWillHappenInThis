package fr.anatom3000.gwwhit.materials.ipacyk;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IpacykBlock extends Block {
public IpacykBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.17412402140856f,1.9681537290110027f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}