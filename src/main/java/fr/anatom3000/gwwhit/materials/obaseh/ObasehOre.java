package fr.anatom3000.gwwhit.materials.obaseh;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class ObasehOre extends Block {
public ObasehOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.43085804245456f,2.0314685723113426f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}