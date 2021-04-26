package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.registry.ItemRegistry;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow public abstract void onDeath(DamageSource source);

    @Shadow @Nullable protected abstract SoundEvent getDeathSound();

    @Shadow protected abstract float getSoundVolume();

    @Shadow protected abstract float getSoundPitch();

    @Shadow public abstract void setAttacker(@Nullable LivingEntity attacker);

    @Shadow protected abstract void applyDamage(DamageSource source, float amount);

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (((Entity)(Object)this).world.isClient) {
            return;
        }
        if (source == DamageSource.FALL && getEquippedStack(EquipmentSlot.FEET).getItem() == ItemRegistry.get("shock_resistant_boots")) {
            cir.setReturnValue(false);
            cir.cancel();
            return;
        }
        Entity attacker = source.getAttacker();
        if (attacker != null && (source.getAttacker() instanceof LivingEntity) && ((LivingEntity) source.getAttacker()).getMainHandStack().getItem() == ItemRegistry.get("reapers_scythe")) {
            applyDamage(source, Float.MAX_VALUE);
            setAttacker((LivingEntity) source.getAttacker());
            if (attacker instanceof PlayerEntity) {
                ((LivingEntityAccessor)this).setAttackingPlayer((PlayerEntity) attacker);
                ((LivingEntityAccessor)this).setPlayerHitTimer(100);
            }
            ((LivingEntityAccessor)this).setLastDamageTaken(Float.MAX_VALUE);
            ((Entity)(Object)this).world.sendEntityStatus((Entity)(Object)this, (byte) 2);
            SoundEvent soundEvent = getDeathSound();
            if (soundEvent != null) {
                ((Entity)(Object)this).playSound(soundEvent, getSoundVolume(), getSoundPitch());
            }
            onDeath(source);

            if (attacker instanceof ServerPlayerEntity) {
                Criteria.PLAYER_HURT_ENTITY.trigger((ServerPlayerEntity)attacker, (Entity)(Object)this, source, 0, Float.MAX_VALUE, false);
            }

            cir.setReturnValue(true);
            cir.cancel();
        }
    }

}
