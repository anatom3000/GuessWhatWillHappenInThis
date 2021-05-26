package fr.anatom3000.gwwhit.materials.pecced;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class PeccedBlock extends Block {
public PeccedBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.6010260796534825f,2.3127495119359955f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}