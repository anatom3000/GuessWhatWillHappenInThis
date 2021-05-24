package fr.anatom3000.gwwhit.materials.fyfat;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class FyfatBlock extends Block {
public FyfatBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.9285772767259357f,1.6451633680577538f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}