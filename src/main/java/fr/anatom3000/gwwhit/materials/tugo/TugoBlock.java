package fr.anatom3000.gwwhit.materials.tugo;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class TugoBlock extends Block {
public TugoBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.200979108884199f,2.039312289399117f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}