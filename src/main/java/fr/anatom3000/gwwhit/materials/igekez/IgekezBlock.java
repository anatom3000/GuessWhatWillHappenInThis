package fr.anatom3000.gwwhit.materials.igekez;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IgekezBlock extends Block {
public IgekezBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.981758085844132f,2.9006502261373526f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}