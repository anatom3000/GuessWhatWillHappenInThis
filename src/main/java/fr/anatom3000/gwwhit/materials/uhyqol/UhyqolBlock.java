package fr.anatom3000.gwwhit.materials.uhyqol;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
public class UhyqolBlock extends Block {
public UhyqolBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.2280044184367513f,3.10489987888608f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

public int getStrongRedstonePower(BlockState state, BlockPos pos, Direction direction) {
return 13;
}
}