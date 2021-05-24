package fr.anatom3000.gwwhit.materials.emussazr;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class EmussazrBlock extends Block {
public EmussazrBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.165230357008876f,4.2314710918464264f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}