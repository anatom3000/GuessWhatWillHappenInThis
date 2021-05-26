package fr.anatom3000.gwwhit.materials.wuhitd;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class WuhitdOre extends Block {
public WuhitdOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.4142621195825815f,1.4998161462391546f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}