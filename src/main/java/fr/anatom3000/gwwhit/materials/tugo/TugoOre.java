package fr.anatom3000.gwwhit.materials.tugo;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class TugoOre extends Block {
public TugoOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.1213986174379613f,2.0118248104123397f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}