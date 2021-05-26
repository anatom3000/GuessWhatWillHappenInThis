package fr.anatom3000.gwwhit.materials.uxurup;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class UxurupBlock extends Block {
public UxurupBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.6794135957403693f,2.2701997525637334f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}