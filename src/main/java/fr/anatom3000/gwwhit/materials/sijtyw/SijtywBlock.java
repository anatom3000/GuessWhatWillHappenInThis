package fr.anatom3000.gwwhit.materials.sijtyw;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class SijtywBlock extends Block {
public SijtywBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.87992097229947f,3.6945125541360677f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}