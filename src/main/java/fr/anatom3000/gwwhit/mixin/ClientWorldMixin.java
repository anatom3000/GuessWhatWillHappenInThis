package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.config.ModConfig;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {
    @Inject(method = "disconnect", at = @At("TAIL"))
    private void onDisconnect(CallbackInfo ci) {
        ModConfig.loadConfig(null);
    }
}
