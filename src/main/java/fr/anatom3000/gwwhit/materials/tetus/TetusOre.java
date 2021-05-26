package fr.anatom3000.gwwhit.materials.tetus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class TetusOre extends Block {
public TetusOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.2374859739810793f,4.074642410067934f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}