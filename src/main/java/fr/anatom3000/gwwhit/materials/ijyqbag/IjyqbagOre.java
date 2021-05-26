package fr.anatom3000.gwwhit.materials.ijyqbag;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IjyqbagOre extends Block {
public IjyqbagOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.59919753651398f,3.932431591499626f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}