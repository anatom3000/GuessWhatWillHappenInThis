package fr.anatom3000.gwwhit.materials.ijyqbag;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IjyqbagBlock extends Block {
public IjyqbagBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.440821872717974f,3.7070076935135803f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}