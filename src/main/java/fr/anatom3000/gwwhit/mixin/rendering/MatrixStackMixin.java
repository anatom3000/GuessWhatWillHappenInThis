package fr.anatom3000.gwwhit.mixin.rendering;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.config.data.RenderingConfig.World;
import fr.anatom3000.gwwhit.util.MathUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MatrixStack.class)
public abstract class MatrixStackMixin {
    private static float increment = 0;

    private static float iv(double v) {
        return MathUtil.boxedInvert((float) v, -0.1f, 0.1f);
    }

    @Inject(method = "translate(DDD)V", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void translate(double x, double y, double z, CallbackInfo ci, MatrixStack.Entry entry) {
        World config = ConfigManager.getActiveConfig().rendering.world;

        if (config.smallBlocks) {
            entry.getPositionMatrix().multiply(Matrix4f.translate(iv(x), iv(y), iv(z)));
        }
        if (config.spin) {
            increment = (increment + MinecraftClient.getInstance().getTickDelta() * 0.00001f) % 360;
            entry.getPositionMatrix().multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(increment));
            entry.getPositionMatrix().multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(increment));
            entry.getPositionMatrix().multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(increment));
        }
        entry.getPositionMatrix().multiply(config.matrixScale);
    }

    @ModifyVariable(method = "translate", at = @At("HEAD"), index = 1)
    public double editTranslateX(double x) {
        return x * ConfigManager.getActiveConfig().rendering.world.matrixTranslationScale;
    }

    @ModifyVariable(method = "translate", at = @At("HEAD"), index = 3)
    public double editTranslateY(double y) {
        return y * ConfigManager.getActiveConfig().rendering.world.matrixTranslationScale;
    }


    @ModifyVariable(method = "translate", at = @At("HEAD"), index = 5)
    public double editTranslateZ(double z) {
        return z * ConfigManager.getActiveConfig().rendering.world.matrixTranslationScale;
    }


    @Inject(method = {"push", "pop"}, at = @At("HEAD"), cancellable = true)
    public void doStuff(CallbackInfo ci) {
        if (!ConfigManager.getActiveConfig().rendering.world.allowMatrixLevels) ci.cancel();
    }
}
