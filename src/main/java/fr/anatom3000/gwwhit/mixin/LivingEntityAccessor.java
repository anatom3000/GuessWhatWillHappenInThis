package fr.anatom3000.gwwhit.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityAccessor {

    @Accessor("attackingPlayer")
    void setAttackingPlayer(PlayerEntity player);

    @Accessor("playerHitTimer")
    void setPlayerHitTimer(int time);

    @Accessor("lastDamageTaken")
    void setLastDamageTaken(float amount);

}
