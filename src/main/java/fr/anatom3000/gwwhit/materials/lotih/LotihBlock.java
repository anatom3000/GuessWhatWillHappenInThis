package fr.anatom3000.gwwhit.materials.lotih;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class LotihBlock extends Block {
public LotihBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.1264012626747317f,1.9996258300620537f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}