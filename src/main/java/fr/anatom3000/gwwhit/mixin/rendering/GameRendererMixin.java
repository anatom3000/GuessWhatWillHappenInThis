package fr.anatom3000.gwwhit.mixin.rendering;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gl.ShaderEffect;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Shadow
    @Nullable
    private ShaderEffect shader;
    private int textWidth;
    private int field_19254;

    @Inject(at = @At("TAIL"), method = "<init>")
    public void injectGameRenderer(MinecraftClient client, ResourceManager resourceManager, BufferBuilderStorage bufferBuilderStorage, CallbackInfo ci) {
        this.field_19254 = 5;
        this.textWidth = 1;
    }

    @Inject(at = @At("TAIL"), method = "render")
    public void render(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        if (!ConfigManager.getActiveConfig().rendering.unregisteredVersion) {
            return;
        }
        int var1 = this.client.getWindow().getScaledWidth();
        TextRenderer textRenderer = this.client.textRenderer;
        MatrixStack stack = new MatrixStack();
        InGameHud.fill(stack, 0, 0, var1, 9 + 4, -65536);
        String string = "UNREGISTERED VERSION";
        textRenderer.draw(stack, string, (float) this.textWidth, 4.0F, -16711936);

        if (this.field_19254++ > 10) {
            this.field_19254 = 0;
            this.textWidth += 5;
            if (this.textWidth > var1) {
                this.textWidth = -textRenderer.getWidth(string);
            }
        }
    }

    @Redirect(method = "renderWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;lerp(FFF)F"))
    private float nauseaTest(float delta, float start, float end) {
        if (ConfigManager.getActiveConfig().rendering.world.nauseaOverride)
            return 1f;
        return MathHelper.lerp(delta, start, end);
    }


    @Redirect(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/GameRenderer;shader:Lnet/minecraft/client/gl/ShaderEffect;"), require = 2)
    private ShaderEffect render_Shader(GameRenderer renderer, float tickDelta) {
        ShaderEffect shader = ConfigManager.shader;

        if (shader != null) {
            shader.setupDimensions(client.getWindow().getFramebufferWidth(), client.getWindow().getFramebufferHeight());
            shader.render(tickDelta);
            return null;
        }
        return this.shader;
    }
}
