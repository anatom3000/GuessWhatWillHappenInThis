package fr.anatom3000.gwwhit.mixin.misc;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.util.ScreenData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static fr.anatom3000.gwwhit.util.ScreenData.SCREENSHOT_TEXTURE;
import static net.minecraft.client.gui.DrawableHelper.drawTexture;

@Mixin(RotatingCubeMapRenderer.class)
public class RotatingCubeMapRendererMixin {

    @Inject(
        method = "render",
        at = @At( value = "HEAD" ),
        cancellable = true
    )
    public void onRenderBackground( float delta, float alpha, CallbackInfo info ) {
        if ( ConfigManager.getActiveConfig().misc.replacePanorama ) {
            info.cancel();
            RenderSystem.setShader( GameRenderer::getPositionTexShader );
            RenderSystem.setShaderTexture( 0, SCREENSHOT_TEXTURE );
            var window = MinecraftClient.getInstance().getWindow();
            drawTexture(
                RenderSystem.getModelViewStack(),
                0,
                0,
                window.getFramebufferWidth(),
                window.getFramebufferHeight(),
                window.getX(),
                window.getY(),
                window.getWidth(),
                window.getHeight(),
                ScreenData.image.getWidth(),
                ScreenData.image.getHeight()
            );
        }
    }
}
