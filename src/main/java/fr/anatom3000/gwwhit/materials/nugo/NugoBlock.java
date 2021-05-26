package fr.anatom3000.gwwhit.materials.nugo;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class NugoBlock extends Block {
public NugoBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.540433387192429f,4.765545385894495f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}