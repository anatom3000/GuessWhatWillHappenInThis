package fr.anatom3000.gwwhit.materials.fyfat;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class FyfatOre extends Block {
public FyfatOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.021983156281999f,1.7899523783311384f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.7672129234315004f));}

}