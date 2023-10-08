package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PersistentProjectileEntity.class)
public interface PersistentProjectileEntityAccessor {
    @Accessor("inBlockState")
    void setInBlockState(BlockState state);

    @Accessor("inBlockState")
    BlockState getInBlockState();

    @Invoker
    boolean callShouldFall();
    
    @Invoker
    void callFall();
}
