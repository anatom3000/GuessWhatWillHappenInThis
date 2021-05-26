package fr.anatom3000.gwwhit.materials.emogy;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class EmogyBlock extends Block {
public EmogyBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.6645702079544282f,3.385852761280221f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}