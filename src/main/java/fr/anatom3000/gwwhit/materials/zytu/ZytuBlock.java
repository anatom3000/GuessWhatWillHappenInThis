package fr.anatom3000.gwwhit.materials.zytu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class ZytuBlock extends Block {
public ZytuBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.181319282819409f,2.856104339048716f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}