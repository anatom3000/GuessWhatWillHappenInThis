package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ProjectileEntity.class)
public interface ProjectileEntityAccessor {
    @Accessor("shot")
    void setShot(boolean hasBeenShot);

    @Accessor("shot")
    boolean getShot();
    
    @Accessor("leftOwner")
    void setLeftOwner(boolean leftOwner);

    @Accessor("leftOwner")
    boolean getLeftOwner();

    @Invoker
    boolean callShouldLeaveOwner();
}
