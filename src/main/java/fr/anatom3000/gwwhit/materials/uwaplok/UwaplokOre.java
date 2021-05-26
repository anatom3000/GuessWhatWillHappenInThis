package fr.anatom3000.gwwhit.materials.uwaplok;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class UwaplokOre extends Block {
public UwaplokOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.6749805451567803f,4.238319247376481f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}