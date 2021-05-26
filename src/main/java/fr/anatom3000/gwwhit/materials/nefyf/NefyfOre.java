package fr.anatom3000.gwwhit.materials.nefyf;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class NefyfOre extends Block {
public NefyfOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.6545992097134476f,1.6291803974155825f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}