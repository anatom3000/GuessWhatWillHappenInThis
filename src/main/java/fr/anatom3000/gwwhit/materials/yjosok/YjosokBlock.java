package fr.anatom3000.gwwhit.materials.yjosok;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class YjosokBlock extends Block {
public YjosokBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.5052900536412075f,1.8634806830581572f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}