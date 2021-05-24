package fr.anatom3000.gwwhit.materials.uwygan;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class UwyganBlock extends Block {
public UwyganBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.348603208170338f,1.8438765823878045f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}