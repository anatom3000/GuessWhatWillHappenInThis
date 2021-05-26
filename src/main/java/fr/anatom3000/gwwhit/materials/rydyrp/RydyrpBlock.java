package fr.anatom3000.gwwhit.materials.rydyrp;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class RydyrpBlock extends Block {
public RydyrpBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.8752172083406142f,1.9167528463130443f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.7405748679791418f));}

}