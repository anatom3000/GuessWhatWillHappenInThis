package fr.anatom3000.gwwhit.materials.wuhitd;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
public class WuhitdBlock extends Block {
public WuhitdBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.071015397878727f,3.720826107525562f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

public int getStrongRedstonePower(BlockState state, BlockPos pos, Direction direction) {
return 12;
}
}