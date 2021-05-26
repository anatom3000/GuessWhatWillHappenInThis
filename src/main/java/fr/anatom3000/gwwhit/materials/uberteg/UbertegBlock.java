package fr.anatom3000.gwwhit.materials.uberteg;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class UbertegBlock extends Block {
public UbertegBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.650320076307138f,1.3782695586894111f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}