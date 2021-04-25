package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.util.MathUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MatrixStack.class)
public abstract class MatrixStackMixin {
    @Inject(method = "translate(DDD)V", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void translate(double x, double y, double z, CallbackInfo ci, MatrixStack.Entry entry) {
        entry.getModel().multiply(Matrix4f.translate(iv(x), iv(y), iv(z)));
    }
    
    private static float iv(double v) {
        return MathUtil.BoxedInvert((float)v, -0.1f, 0.1f);
    }
}
