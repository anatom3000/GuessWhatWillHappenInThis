package fr.anatom3000.gwwhit.materials.fucox;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class FucoxOre extends Block {
public FucoxOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.2476019435773864f,2.6980823120057074f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}