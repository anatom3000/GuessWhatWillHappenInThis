package fr.anatom3000.gwwhit.block;

import fr.anatom3000.gwwhit.block.entity.RandomisingBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class RandomisingBlock extends BlockWithEntity {
    public RandomisingBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new RandomisingBlockEntity();
    }
}