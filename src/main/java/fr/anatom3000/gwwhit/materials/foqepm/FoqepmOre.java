package fr.anatom3000.gwwhit.materials.foqepm;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class FoqepmOre extends Block {
public FoqepmOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.880363390947983f,4.972960277192808f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.7240324768934855f));}

}