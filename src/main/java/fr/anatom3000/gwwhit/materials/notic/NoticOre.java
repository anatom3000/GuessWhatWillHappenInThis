package fr.anatom3000.gwwhit.materials.notic;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class NoticOre extends Block {
public NoticOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.6419959483162745f,3.11053404379917f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}