package fr.anatom3000.gwwhit.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;

@Mixin(Entity.class)
public interface EntityAccessor {
    @Accessor("blockStateAtPos")
    void setBlockStateAtPos(BlockState feetBlockState);
    
    @Invoker
    void callUpdateSubmergedInWaterState();
}
