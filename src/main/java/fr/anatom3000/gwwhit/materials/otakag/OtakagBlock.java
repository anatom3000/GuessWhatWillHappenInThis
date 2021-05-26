package fr.anatom3000.gwwhit.materials.otakag;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class OtakagBlock extends Block {
public OtakagBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.7011058362365903f,1.403393897078998f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}