package fr.anatom3000.gwwhit.mixin;

import net.minecraft.MinecraftVersion;
import net.minecraft.util.Language;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Explosion.class)
public class ExplosionMixin
{
    @Inject(at = @At("HEAD"), method = "collectBlocksAndDamageEntities", cancellable = true)
    private void MethodNameYouWant(CallbackInfo ci){
        ci.cancel();
    }
}
