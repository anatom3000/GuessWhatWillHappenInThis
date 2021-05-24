package fr.anatom3000.gwwhit.materials.obuxan;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class ObuxanOre extends Block {
public ObuxanOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.417769252878823f,3.5287271532378037f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}