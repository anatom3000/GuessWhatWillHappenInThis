package fr.anatom3000.gwwhit.mixin.misc;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.util.ResourceUtil;
import fr.anatom3000.gwwhit.util.ScreenData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.render.GameRenderer;
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

import static fr.anatom3000.gwwhit.util.ScreenData.SCREENSHOT_TEXTURE;

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
            value = "RETURN",
            target = "Lnet/minecraft/client/gui/RotatingCubeMapRenderer;render(FF)V"
        ),
        locals = LocalCapture.CAPTURE_FAILEXCEPTION
    )
    public void onRenderBackground( MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo info, float alpha ) {
        if ( ConfigManager.getActiveConfig().misc.replacePanorama ) {
            RenderSystem.setShader( GameRenderer::getPositionTexShader );
            RenderSystem.setShaderTexture( 0, SCREENSHOT_TEXTURE );
            var window = MinecraftClient.getInstance().getWindow();
            drawTexture(
                matrices,
                0,
                0,
                this.width,
                this.height,
                window.getX() + ScreenData.getWindowDecorations().left * 2,
                window.getY() + ScreenData.getWindowDecorations().top * 2,
                window.getWidth(),
                window.getHeight(),
                ScreenData.image.getWidth(),
                ScreenData.image.getHeight()
            );
            matrices.scale( .8f, .8f, .8f );
        }
    }
}
