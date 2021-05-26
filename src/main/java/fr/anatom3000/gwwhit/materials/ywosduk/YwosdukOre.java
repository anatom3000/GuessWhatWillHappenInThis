package fr.anatom3000.gwwhit.materials.ywosduk;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class YwosdukOre extends Block {
public YwosdukOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.14771438823258f,2.5014601880671057f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}