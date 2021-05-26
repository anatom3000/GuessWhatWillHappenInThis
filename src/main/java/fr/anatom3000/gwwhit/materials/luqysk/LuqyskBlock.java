package fr.anatom3000.gwwhit.materials.luqysk;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class LuqyskBlock extends Block {
public LuqyskBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.2179804984444f,2.4804128513426646f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.9952457451652684f));}

}