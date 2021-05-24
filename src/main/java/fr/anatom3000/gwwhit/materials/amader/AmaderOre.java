package fr.anatom3000.gwwhit.materials.amader;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class AmaderOre extends Block {
public AmaderOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.505565659243803f,1.0655254386080033f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}