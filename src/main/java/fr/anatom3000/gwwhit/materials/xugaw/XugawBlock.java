package fr.anatom3000.gwwhit.materials.xugaw;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class XugawBlock extends Block {
public XugawBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.4894045079779175f,3.602666379676259f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}