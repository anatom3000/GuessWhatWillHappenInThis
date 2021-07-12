package fr.anatom3000.gwwhit.block.entity;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomisingBlockEntity extends BlockEntity {
    private static final Random RANDOM = new Random();
    public static int removeTick = -1;

    private int usesRemaining = ConfigManager.getLoadedConfig().content.blocks.randomisingBlock.totalPlacements;
    private int cooldown = ConfigManager.getLoadedConfig().content.blocks.randomisingBlock.ticksBetweenPlacements;
    private BlockPos.Mutable placePos = new BlockPos.Mutable();

    public RandomisingBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.RANDOMISING_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, RandomisingBlockEntity be) {
        assert world != null;
        if (!world.isClient) {
            if (((ServerWorld) world).getServer().getTicks() == removeTick + 1) {
                world.breakBlock(pos, false);
            }

            --be.cooldown;
            if (be.cooldown <= 0) {
                --be.usesRemaining;
                be.cooldown = ConfigManager.getLoadedConfig().content.blocks.randomisingBlock.ticksBetweenPlacements;
                be.placePos.move(Direction.random(RANDOM));
                if (be.placePos.equals(BlockPos.ORIGIN)) be.placePos.move(Direction.random(RANDOM));

                world.setBlockState(pos.add(be.placePos), be.getRandomState(), 3);
            }
            if (be.usesRemaining == 0) {
                world.breakBlock(pos, true);
            }
        }
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        usesRemaining = tag.getInt("usesRemaining");
        cooldown = tag.getInt("cooldown");
        NbtCompound posTag = tag.getCompound("placePos");
        placePos = new BlockPos.Mutable(posTag.getInt("x"), posTag.getInt("y"), posTag.getInt("z"));
    }

    @Override
    public NbtCompound writeNbt(NbtCompound tag) {
        tag.putInt("usesRemaining", usesRemaining);
        tag.putInt("cooldown", cooldown);
        NbtCompound posTag = new NbtCompound();
        posTag.putInt("x", placePos.getX());
        posTag.putInt("y", placePos.getY());
        posTag.putInt("z", placePos.getZ());
        tag.put("placePos", posTag);
        return super.writeNbt(tag);
    }

    private BlockState getRandomState() {
        List<String> blacklist = ConfigManager.getLoadedConfig().content.blocks.randomisingBlock.blockBlacklist;
        List<Block> blocks = Registry.BLOCK.getIds().stream().filter(id -> !blacklist.contains(id.toString())).map(Registry.BLOCK::get).collect(Collectors.toList());

        BlockState state = blocks.get(RANDOM.nextInt(blocks.size())).getDefaultState();

        //scramble state
        if (ConfigManager.getLoadedConfig().content.blocks.randomisingBlock.scrambleBlockState) {
            for (Property<?> property : state.getProperties()) {
                state = scrambleProperty(property, state);
            }
        }

        //remove water-logging
        if (ConfigManager.getLoadedConfig().content.blocks.randomisingBlock.deWaterlog && state.contains(Properties.WATERLOGGED))
            state = state.with(Properties.WATERLOGGED, false);

        return state;
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> BlockState scrambleProperty(Property<T> property, BlockState state) {
        //get possible values
        Object[] values = property.getValues().toArray();
        //get a random one
        T value = (T) values[RANDOM.nextInt(values.length)];
        //add it
        return state.with(property, value);
    }
}
