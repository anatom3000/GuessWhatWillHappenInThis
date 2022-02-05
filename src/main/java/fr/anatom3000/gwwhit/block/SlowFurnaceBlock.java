package fr.anatom3000.gwwhit.block;

import fr.anatom3000.gwwhit.block.entity.SlowFurnaceBlockEntity;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
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
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

@SuppressWarnings("deprecation")
public class SlowFurnaceBlock extends BlockWithEntity implements InventoryProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty LIT = Properties.LIT;

    public SlowFurnaceBlock() {
        super(
                Settings.of(Material.STONE)
                        .requiresTool()
                        .strength(3.5F)
                        .luminance(state -> state.get(Properties.LIT) ? 13 : 0)
        );
        this.setDefaultState(
                this.stateManager.getDefaultState()
                        .with( FACING, Direction.NORTH )
                        .with( LIT, false )
        );
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SlowFurnaceBlockEntity(pos, state);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if ( world.isClient ) {
            return ActionResult.SUCCESS;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if ( blockEntity instanceof SlowFurnaceBlockEntity entity ) {
            player.openHandledScreen( entity );
            player.incrementStat(Stats.INTERACT_WITH_FURNACE);
        }
        return ActionResult.CONSUME;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? null : checkType(
                type,
                BlockEntityRegistry.SLOW_FURNACE_BLOCK_ENTITY,
                SlowFurnaceBlockEntity::tick
        );
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (! state.get(LIT) ) {
            return;
        }
        double d = (double) pos.getX() + 0.5;
        double e = pos.getY();
        double f = (double) pos.getZ() + 0.5;
        if (random.nextDouble() < 0.1) {
            world.playSound(
                    d,
                    e,
                    f,
                    SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE,
                    SoundCategory.BLOCKS,
                    1.0f,
                    1.0f,
                    false
            );
        }
        Direction direction = state.get(FACING);
        Direction.Axis axis = direction.getAxis();
        double g = 0.52;
        double h = random.nextDouble() * 0.6 - 0.3;
        double i = axis == Direction.Axis.X ? (double) direction.getOffsetX() * g : h;
        double j = random.nextDouble() * 6.0 / 16.0;
        double k = axis == Direction.Axis.Z ? (double) direction.getOffsetZ() * g : h;
        world.addParticle( ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0, 0.0, 0.0 );
        world.addParticle( ParticleTypes.FLAME, d + i, e + j, f + k, 0.0, 0.0, 0.0 );
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return null;
    }

    @Override
    public BlockState getPlacementState(@NotNull ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public void onStateReplaced(@NotNull BlockState state, World world, BlockPos pos, @NotNull BlockState newState, boolean moved) {
        if (! state.isOf( newState.getBlock() ) ) {
            if ( world.getBlockEntity(pos) instanceof SlowFurnaceBlockEntity entity ) {
                if ( world instanceof ServerWorld ) {
                    ItemScatterer.spawn( world, pos, entity );
//                    entity.getRecipesUsedAndDropExperience( serverWorld, Vec3d.ofCenter(pos) );
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
        builder.add( FACING, LIT );
    }
}
