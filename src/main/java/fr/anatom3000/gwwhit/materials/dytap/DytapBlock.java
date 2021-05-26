package fr.anatom3000.gwwhit.materials.dytap;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class DytapBlock extends Block {
    public DytapBlock() {
        super(FabricBlockSettings.of(Material.METAL).strength(3.645578709719988f, 4.087755948920265f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    }

    public int getStrongRedstonePower(BlockState state, BlockPos pos, Direction direction) {
        return 11;
    }
}