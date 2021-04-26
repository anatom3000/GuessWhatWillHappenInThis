package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.registry.ItemRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source == DamageSource.FALL && getEquippedStack(EquipmentSlot.FEET).getItem() == ItemRegistry.get("shock_resistant_boots")) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

}
