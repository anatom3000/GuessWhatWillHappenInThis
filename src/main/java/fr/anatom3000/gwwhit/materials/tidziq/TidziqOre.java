package fr.anatom3000.gwwhit.materials.tidziq;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class TidziqOre extends Block {
public TidziqOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.6496302854756935f,3.218823129572453f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}