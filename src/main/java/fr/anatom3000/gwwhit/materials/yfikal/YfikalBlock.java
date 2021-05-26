package fr.anatom3000.gwwhit.materials.yfikal;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class YfikalBlock extends Block {
public YfikalBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.102072885735272f,3.9307575802439843f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}