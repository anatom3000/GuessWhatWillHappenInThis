package fr.anatom3000.gwwhit.materials.nefyf;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class NefyfBlock extends Block {
public NefyfBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.0514950684122697f,4.11407684648582f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}