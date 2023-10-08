package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityAccessor {
    @Accessor("blockStateAtPos")
    void setBlockStateAtPos(BlockState feetBlockState);

    @Accessor("blockStateAtPos")
    BlockState getBlockStateAtPos();
    
    @Invoker
    void callUpdateSubmergedInWaterState();
}
