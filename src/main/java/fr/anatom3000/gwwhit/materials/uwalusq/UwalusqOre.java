package fr.anatom3000.gwwhit.materials.uwalusq;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class UwalusqOre extends Block {
public UwalusqOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.377612215255365f,4.642682211595366f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}