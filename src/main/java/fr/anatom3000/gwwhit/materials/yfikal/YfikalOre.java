package fr.anatom3000.gwwhit.materials.yfikal;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class YfikalOre extends Block {
public YfikalOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.426399344319657f,2.1756509197354643f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}