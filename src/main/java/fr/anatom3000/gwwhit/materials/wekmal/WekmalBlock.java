package fr.anatom3000.gwwhit.materials.wekmal;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class WekmalBlock extends Block {
public WekmalBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.626049772608876f,4.792349075006154f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}