package fr.anatom3000.gwwhit.materials.lysum;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class LysumBlock extends Block {
public LysumBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.1578215449520575f,4.975809376894033f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}