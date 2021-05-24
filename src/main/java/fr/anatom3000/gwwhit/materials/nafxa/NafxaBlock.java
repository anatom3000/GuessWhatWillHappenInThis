package fr.anatom3000.gwwhit.materials.nafxa;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class NafxaBlock extends Block {
public NafxaBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.748258534596772f,4.567033414822431f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}