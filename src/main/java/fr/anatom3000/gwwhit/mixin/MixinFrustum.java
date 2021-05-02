package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(Frustum.class)
public class MixinFrustum {

    @Inject(method = "isVisible(DDDDDD)Z", at = @At("HEAD"), cancellable = true)
    public void isVisible(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, CallbackInfoReturnable<Boolean> cir) {
        if (Config.getInstance().getValue(Config.DISABLE_FRUSTUM_CULLING_KEY)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

}