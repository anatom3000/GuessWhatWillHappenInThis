package fr.anatom3000.gwwhit.materials.uruwogq;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class UruwogqOre extends Block {
public UruwogqOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.326361572300289f,2.987653755665146f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}