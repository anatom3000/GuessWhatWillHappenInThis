package fr.anatom3000.gwwhit.block;

import fr.anatom3000.gwwhit.block.entity.MulticolorBlockEntity;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * CONTROLS:
 *  - Sneak + Attack: Increase light ( reset to 0 if 15 )
 *  - Attack: Change color channel
 *  - Sneak + Interact: Decrease color value ( reset to 255 if 0 )
 *  - Interact: Increase color value ( reset to 0 if 255 )
 */
@SuppressWarnings("deprecation")
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

    @Override
    public ActionResult onUse( BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit ) {
        if ( world.isClient() )
            return ActionResult.PASS;
        if ( world.getBlockEntity( pos ) instanceof MulticolorBlockEntity entity ) {
            if ( player.isSneaking() ) {
                entity.decrease();
            } else {
                entity.increase();
            }
            entity.markDirty();
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void onBlockBreakStart( BlockState state, World world, BlockPos pos, PlayerEntity player ) {
        if ( world.isClient() )
            return;
        if ( world.getBlockEntity( pos ) instanceof MulticolorBlockEntity entity ) {
            if ( player.isSneaking() ) {
                entity.increaseLight();
            } else {
                entity.nextChannel();
            }
            entity.markDirty();
        }
    }
}
