package fr.anatom3000.gwwhit.materials.aqyqyf;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class AqyqyfOre extends Block {
public AqyqyfOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.5719358374057593f,4.335500428922923f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}