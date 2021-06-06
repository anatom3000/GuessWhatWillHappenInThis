package fr.anatom3000.gwwhit.block.entity;

import fr.anatom3000.gwwhit.config.ModConfig;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import fr.anatom3000.gwwhit.registry.BlockRegistry;
import fr.anatom3000.gwwhit.util.MathUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InfectedMassBlockEntity extends BlockEntity {
    public static int removeTick = -1;

    private int timer = -1;

    public InfectedMassBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.INFECTED_MASS_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, InfectedMassBlockEntity be) {
        assert world != null;
        if (!world.isClient) {
            if (((ServerWorld) world).getServer().getTicks() == removeTick + 1)
                world.breakBlock(pos, false);

            be.timer = (be.timer + 1) % ModConfig.getLoadedConfig().content.blocks.infectedMassBlock.ticksBetweenSpread;
            if (be.timer != 0) {
                return;
            }
            if (MathUtil.getChance(ModConfig.getLoadedConfig().content.blocks.infectedMassBlock.globalSpreadChance)) {
                return;
            }
            int completed = 0;
            

            completed = be.getCompleted(pos.north(), completed);
            completed = be.getCompleted(pos.south(), completed);
            completed = be.getCompleted(pos.up(), completed);
            completed = be.getCompleted(pos.down(), completed);
            completed = be.getCompleted(pos.east(), completed);
            completed = be.getCompleted(pos.west(), completed);

            if (completed == 6) {
                world.setBlockState(pos, BlockRegistry.get("inert_infected_mass").getDefaultState());
            }
        }
    }

    private int getCompleted(BlockPos newPos, int completed) {
        BlockState state;
        state = world.getBlockState(newPos);
        if (ModConfig.getLoadedConfig().content.blocks.infectedMassBlock.spreadBlacklist.contains(state.getBlock())) {
            return completed + 1;
        } else if (MathUtil.getChance(ModConfig.getLoadedConfig().content.blocks.infectedMassBlock.directionalSpreadChance)) {
            world.setBlockState(newPos, this.getCachedState());
        }
        return completed;
    }

}
