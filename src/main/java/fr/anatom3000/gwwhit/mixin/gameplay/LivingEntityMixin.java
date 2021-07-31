package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.mixin.access.LivingEntityAccessor;
import fr.anatom3000.gwwhit.registry.ItemRegistry;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    private static final UUID DASHING_SPEED_BOOST_ID = UUID.fromString("130b4542-4a89-5046-9e87-acbb7577a76b");
    private static final EntityAttributeModifier DASHING_SPEED_BOOST = new EntityAttributeModifier(DASHING_SPEED_BOOST_ID, "Dashing speed boost", 0.25D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    private int dashTicks = 0;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow
    public abstract void onDeath(DamageSource source);

    @Shadow
    @Nullable
    protected abstract SoundEvent getDeathSound();

    @Shadow
    protected abstract float getSoundVolume();

    @Shadow
    public abstract float getSoundPitch();

    @Shadow
    public abstract void setAttacker(@Nullable LivingEntity attacker);

    @Shadow
    protected abstract void applyDamage(DamageSource source, float amount);

    @Shadow
    @Nullable
    public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute attribute);

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (this.world.isClient) return;
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
                ((LivingEntityAccessor) this).setAttackingPlayer((PlayerEntity) attacker);
                ((LivingEntityAccessor) this).setPlayerHitTimer(100);
            }
            ((LivingEntityAccessor) this).setLastDamageTaken(Float.MAX_VALUE);
            this.world.sendEntityStatus(this, (byte) 2);
            SoundEvent soundEvent = getDeathSound();
            if (soundEvent != null) {
                this.playSound(soundEvent, getSoundVolume(), getSoundPitch());
            }
            onDeath(source);

            if (attacker instanceof ServerPlayerEntity) {
                Criteria.PLAYER_HURT_ENTITY.trigger((ServerPlayerEntity) attacker, this, source, 0, Float.MAX_VALUE, false);
            }

            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(method = "tickMovement", at = @At("TAIL"))
    public void tickMovement(CallbackInfo ci) {
        if (getEquippedStack(EquipmentSlot.FEET).getItem() != ItemRegistry.get("dashing_boots")) {
            return;
        }
        if (!isSprinting()) {
            dashTicks = 0;
            return;
        } else {
            ++dashTicks;
        }
        EntityAttributeInstance entityAttributeInstance = getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (entityAttributeInstance.getModifier(DASHING_SPEED_BOOST_ID) != null) {
            entityAttributeInstance.removeModifier(DASHING_SPEED_BOOST);
        }
        if (dashTicks >= 20) {
            dashTicks = 20;
            entityAttributeInstance.addTemporaryModifier(DASHING_SPEED_BOOST);
        }
    }
}
