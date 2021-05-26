package fr.anatom3000.gwwhit.materials.izymam;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IzymamBlock extends Block {
public IzymamBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.279469982202987f,1.0907666269647844f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}