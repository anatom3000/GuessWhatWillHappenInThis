package fr.anatom3000.gwwhit.materials.wekmal;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class WekmalOre extends Block {
public WekmalOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.0999565424338655f,2.2627085630941344f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}