package fr.anatom3000.gwwhit.materials.tesxes;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class TesxesOre extends Block {
public TesxesOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.307610301978136f,1.868869433512132f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}