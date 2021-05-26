package fr.anatom3000.gwwhit.materials.nugo;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class NugoOre extends Block {
public NugoOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.5944410167235135f,2.9528731166038953f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).luminance(5));}

}