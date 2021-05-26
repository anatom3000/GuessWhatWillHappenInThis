package fr.anatom3000.gwwhit.materials.obuxan;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class ObuxanBlock extends Block {
public ObuxanBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.4681756822411787f,2.2692449252063347f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}