package fr.anatom3000.gwwhit.materials.folso;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class FolsoBlock extends Block {
    public FolsoBlock() {
        super(FabricBlockSettings.of(Material.METAL).strength(1.8846039355518553f, 4.429535277822083f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    }

    public int getStrongRedstonePower(BlockState state, BlockPos pos, Direction direction) {
        return 1;
    }
}