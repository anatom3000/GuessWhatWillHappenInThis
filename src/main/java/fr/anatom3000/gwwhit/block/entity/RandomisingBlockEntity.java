package fr.anatom3000.gwwhit.block.entity;

import fr.anatom3000.gwwhit.config.ModConfig;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomisingBlockEntity extends BlockEntity implements Tickable {
    private static final Random RANDOM = new Random();
    
    private int usesRemaining = ModConfig.getLoadedConfig().blocks.randomisingBlock.totalPlacements;
    private int cooldown = ModConfig.getLoadedConfig().blocks.randomisingBlock.ticksBetweenPlacements;
    private BlockPos.Mutable placePos = new BlockPos.Mutable();
    
    public RandomisingBlockEntity() {
        super(BlockEntityRegistry.RANDOMISING_BLOCK_ENTITY);
    }
    
    
    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        usesRemaining = tag.getInt("usesRemaining");
        cooldown = tag.getInt("cooldown");
        CompoundTag posTag = tag.getCompound("placePos");
        placePos = new BlockPos.Mutable(posTag.getInt("x"), posTag.getInt("y"), posTag.getInt("z"));
    }
    
    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag.putInt("usesRemaining", usesRemaining);
        tag.putInt("cooldown", cooldown);
        CompoundTag posTag = new CompoundTag();
        posTag.putInt("x", placePos.getX());
        posTag.putInt("y", placePos.getY());
        posTag.putInt("z", placePos.getZ());
        tag.put("placePos", posTag);
        return super.toTag(tag);
    }
    
    @Override
    public void tick() {
        assert world != null;
        if (!world.isClient) {
            --cooldown;
            if (cooldown <= 0) {
                --usesRemaining;
                cooldown = ModConfig.getLoadedConfig().blocks.randomisingBlock.ticksBetweenPlacements;
                placePos.move(Direction.random(RANDOM));
                if (placePos.equals(BlockPos.ORIGIN)) placePos.move(Direction.random(RANDOM));
        
                world.setBlockState(pos.add(placePos), getRandomState(), 3);
            }
            if (usesRemaining == 0) {
                world.breakBlock(pos, true);
            }
        }
    }
    
    private BlockState getRandomState() {
        List<String> blacklist = ModConfig.getLoadedConfig().blocks.randomisingBlock.blockBlackList;
        List<Block> blocks = Registry.BLOCK.getIds().stream().filter(id -> !blacklist.contains(id.toString())).map(Registry.BLOCK::get).collect(Collectors.toList());
        
        BlockState state = blocks.get(RANDOM.nextInt(blocks.size())).getDefaultState();
        
        //scramble state
        if (ModConfig.getLoadedConfig().blocks.randomisingBlock.scrambleBlockState) {
            for (Property<?> property : state.getProperties()) {
                state = scrambleProperty(property, state);
            }
        }
        
        //remove water-logging
        if (ModConfig.getLoadedConfig().blocks.randomisingBlock.deWaterlog && state.contains(Properties.WATERLOGGED))
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