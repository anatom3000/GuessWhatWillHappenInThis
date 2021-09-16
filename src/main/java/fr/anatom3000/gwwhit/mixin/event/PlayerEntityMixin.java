package fr.anatom3000.gwwhit.mixin.event;

import fr.anatom3000.gwwhit.event.PlayerDeathEvent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject( method = "onDeath", at = @At("TAIL") )
    public void onOnDeath(DamageSource source, CallbackInfo ci) {
        PlayerDeathEvent.PLAYER_DEATH.invoker().onDeath( (PlayerEntity) (Object) this );
    }

}
