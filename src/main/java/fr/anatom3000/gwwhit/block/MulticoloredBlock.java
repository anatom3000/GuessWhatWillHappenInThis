package fr.anatom3000.gwwhit.block;

import fr.anatom3000.gwwhit.block.entity.MulticolorBlockEntity;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class MulticoloredBlock extends BlockWithEntity {

    public MulticoloredBlock() {
        super(
                FabricBlockSettings.of(Material.STONE)
                        .hardness(6)
                        .resistance(6)
                        .emissiveLighting( (state, world, pos ) ->
                            world.getBlockEntity(pos, BlockEntityRegistry.MULTICOLOR_BLOCK_ENTITY)
                                    .map( MulticolorBlockEntity::getLight )
                                    .orElse( (short) 0 ) > 0
                        )
                        .sounds(BlockSoundGroup.STONE)
                        .requiresTool()
        );
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MulticolorBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
