package fr.anatom3000.gwwhit.materials.emilamd;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class EmilamdOre extends Block {
public EmilamdOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.000558898654879f,2.424559117826216f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).luminance(5));}

}