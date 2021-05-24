package fr.anatom3000.gwwhit.materials.jipna;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class JipnaBlock extends Block {
public JipnaBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.011898314201292f,2.9745555629681393f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}