package fr.anatom3000.gwwhit.block;

import fr.anatom3000.gwwhit.block.entity.FurnaceBlockEntity;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

/**
 * @author ENDERZOMBI102
 */
@SuppressWarnings("deprecation")
public class FurnaceBlock extends BlockWithEntity {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty LIT = Properties.LIT;

    public FurnaceBlock() {
        super(
                FabricBlockSettings.of(Material.METAL)
                        .requiresTool()
                        .breakByTool(FabricToolTags.PICKAXES)
                        .sounds(BlockSoundGroup.METAL)
                        .hardness(12)
                        .resistance(8)
                        // if burning we emit light, because its pretty
                        .luminance( state -> state.get(LIT) ? 15 : 0 )
        );
        this.setDefaultState(
                this.stateManager.getDefaultState()
                        .with(FACING, Direction.NORTH)
                        .with(LIT, false)
        );
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FurnaceBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            // C O M P A C T
            if ( world.getBlockEntity(pos) instanceof FurnaceBlockEntity furnaceBlockEntity) {
                player.openHandledScreen( furnaceBlockEntity );
                player.incrementStat( Stats.INTERACT_WITH_FURNACE );
            }
            return ActionResult.CONSUME;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with( FACING, ctx.getPlayerFacing().getOpposite() );
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (! state.isOf( newState.getBlock() ) ) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof FurnaceBlockEntity furnaceEntity) {
                if (world instanceof ServerWorld serverWorld) {
                    ItemScatterer.spawn(world, pos, furnaceEntity);
                    furnaceEntity.dropExperience( serverWorld, Vec3d.ofCenter(pos) );
                }

                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput( world.getBlockEntity(pos) );
    }

    @Override
    @Environment(EnvType.CLIENT)
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with( FACING, rotation.rotate( state.get(FACING) ) );
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate( mirror.getRotation( state.get(FACING) ) );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if ( state.get(LIT) ) {
            double x = pos.getX() + 0.5D;
            double y = pos.getY();
            double z = pos.getZ() + 0.5D;
            if (random.nextDouble() < 0.1D) {
                world.playSound(
                        x,
                        y,
                        z,
                        SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE,
                        SoundCategory.BLOCKS,
                        1.0F,
                        1.0F,
                        false
                );
            }

            Direction direction = state.get(FACING);
            Direction.Axis axis = direction.getAxis();
            double rand = random.nextDouble() * 0.6D - 0.3D;
            double offsetX = axis == Direction.Axis.X ? direction.getOffsetX() * 0.52D : rand;
            double offsetY = random.nextDouble() * 6.0D / 16.0D;
            double offsetZ = axis == Direction.Axis.Z ? direction.getOffsetZ() * 0.52D : rand;
            world.addParticle(
                    ParticleTypes.SMOKE,
                    x + offsetX,
                    y + offsetY,
                    z + offsetZ,
                    0.0D,
                    0.0D,
                    0.0D
            );
            world.addParticle(
                    ParticleTypes.FLAME,
                    x + offsetX,
                    y + offsetY,
                    z + offsetZ,
                    0.0D,
                    0.0D,
                    0.0D
            );
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockEntityRegistry.FURNACE_BLOCK_ENTITY, FurnaceBlockEntity::tick);
    }
}
