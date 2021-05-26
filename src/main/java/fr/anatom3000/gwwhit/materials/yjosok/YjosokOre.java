package fr.anatom3000.gwwhit.materials.yjosok;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class YjosokOre extends Block {
public YjosokOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.3993136294626387f,4.010573373808318f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}