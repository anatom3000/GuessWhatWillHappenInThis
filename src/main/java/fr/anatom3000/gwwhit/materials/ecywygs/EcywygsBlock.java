package fr.anatom3000.gwwhit.materials.ecywygs;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class EcywygsBlock extends Block {
public EcywygsBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.3828486778747457f,2.4402466979820847f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}