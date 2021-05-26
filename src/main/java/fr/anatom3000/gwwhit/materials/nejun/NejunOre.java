package fr.anatom3000.gwwhit.materials.nejun;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class NejunOre extends Block {
public NejunOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.0202239094265817f,2.2594521275959054f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}