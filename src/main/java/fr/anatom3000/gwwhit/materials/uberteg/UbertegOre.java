package fr.anatom3000.gwwhit.materials.uberteg;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class UbertegOre extends Block {
public UbertegOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.839481016192175f,3.194925813277477f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}