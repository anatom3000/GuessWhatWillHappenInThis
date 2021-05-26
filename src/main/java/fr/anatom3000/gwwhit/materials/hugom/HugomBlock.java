package fr.anatom3000.gwwhit.materials.hugom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class HugomBlock extends Block {
public HugomBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.898667262197131f,3.7385198932044745f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}