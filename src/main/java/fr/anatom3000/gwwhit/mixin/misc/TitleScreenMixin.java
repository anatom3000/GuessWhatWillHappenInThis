package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.util.ResourceUtil;
import fr.anatom3000.gwwhit.util.Screenshotter;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.math.MatrixStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    @Shadow
    @Nullable
    private String splashText;

    private TitleScreenMixin() {
        super(null);
    }

    @ModifyConstant(method = "render(Lnet/minecraft/client/util/math/MatrixStack;IIF)V", constant = {@Constant(intValue = 98), @Constant(intValue = 88)})
    public int repositionEdition(int old) {
        int i = old;

        if (old == 98) i += 30;
        if (old == 88) i -= 15;

        return i;
    }

    @Inject(at = @At("RETURN"), method = "init()V")
    public void initPost(CallbackInfo info) {
        if (ConfigManager.getActiveConfig().misc.beemovie.replaceSplashes)
            splashText = ResourceUtil.getBeeMovieRandomLine(true);
    }

    @Inject(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/RotatingCubeMapRenderer;render(FF)V"
        ),
        locals = LocalCapture.CAPTURE_FAILEXCEPTION,
        cancellable = true
    )
    public void onRenderBackground( MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo info, float alpha ) {
        if ( ConfigManager.getActiveConfig().misc.replacePanorama ) {
            info.cancel();
            var texture = (NativeImageBackedTexture) Screenshotter.getNativeImageBackedTexture();
            //noinspection ConstantConditions
            drawTexture(
                matrices,
                0,
                0,
                this.width,
                this.height,
                0.0F,
                0.0F,
                texture.getImage().getWidth(),
                texture.getImage().getHeight(),
                texture.getImage().getWidth(),
                texture.getImage().getHeight()
            );
        }
    }
}
