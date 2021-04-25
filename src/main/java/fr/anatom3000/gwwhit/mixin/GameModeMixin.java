package fr.anatom3000.gwwhit.mixin;

import net.minecraft.world.GameMode;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMode.class)
public class GameModeMixin
{
    @Inject(at = @At("HEAD"), method = "setAbilities", cancellable = true)
    private void MethodNameYouWant(CallbackInfo ci){
        ci.cancel();
    }
}
