package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.gui.screen.FoolsSplashOverlay;
import fr.anatom3000.gwwhit.mixin.access.SplashOverlayAccess;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Overlay;
import net.minecraft.client.gui.screen.SplashOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow Overlay overlay;
    MinecraftClient client = MinecraftClient.getInstance();

    @Inject(method = "setOverlay", at = @At("TAIL"))
    public void injectSetOverlay(Overlay oldOverlay, CallbackInfo ci) {
        if (oldOverlay instanceof SplashOverlay && ConfigManager.getActiveConfig().misc.foolsSplashScreen) {
            if (!((SplashOverlayAccess) oldOverlay).getReloading())
                overlay = new FoolsSplashOverlay(((SplashOverlayAccess) oldOverlay).getReload(), ((SplashOverlayAccess) oldOverlay).getExceptionHandler());
        }
    }
}
