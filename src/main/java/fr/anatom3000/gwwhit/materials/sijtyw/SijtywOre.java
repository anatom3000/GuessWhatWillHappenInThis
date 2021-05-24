package fr.anatom3000.gwwhit.materials.sijtyw;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class SijtywOre extends Block {
public SijtywOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.3281622699266435f,3.0974911198906443f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}