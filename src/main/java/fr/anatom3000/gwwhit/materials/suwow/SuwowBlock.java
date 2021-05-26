package fr.anatom3000.gwwhit.materials.suwow;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class SuwowBlock extends Block {
public SuwowBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.1801718777884025f,3.635981503342259f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}