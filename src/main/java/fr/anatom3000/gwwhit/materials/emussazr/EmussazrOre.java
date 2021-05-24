package fr.anatom3000.gwwhit.materials.emussazr;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class EmussazrOre extends Block {
public EmussazrOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.155009599362658f,2.291764654354482f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}