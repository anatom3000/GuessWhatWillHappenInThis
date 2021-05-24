package fr.anatom3000.gwwhit.materials.gigyh;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class GigyhOre extends Block {
public GigyhOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.6065300153686977f,3.2447097769978046f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}