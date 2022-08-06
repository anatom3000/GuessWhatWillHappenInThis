package fr.anatom3000.gwwhit.gui.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Overlay;
import net.minecraft.client.render.*;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceReload;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;

import java.util.Optional;
import java.util.function.Consumer;

import static fr.anatom3000.gwwhit.GWWHITClient.MOJAAAANG_SOUND;

public class FoolsSplashOverlay extends Overlay {
    private static final Identifier MOJANG_LOGO = new Identifier("gwwhit:textures/gui/mojang_logo.png");
    private static final Identifier MOJANG_TEXT = new Identifier("gwwhit:textures/gui/mojang_text.png");
    private SplashScreenStage splashScreenStage = SplashScreenStage.INIT;
    private long field_38636 = -1L;
    private float field_38637;
    private long field_38638;
    private SoundInstance soundInstance;
    private final MinecraftClient client = MinecraftClient.getInstance();
    private final ResourceReload resourceReload;
    private final Consumer<Optional<Throwable>> optionalConsumer;
    private float field_38643;
    private final SplashScreenTypes splashScreenTypes;

    public FoolsSplashOverlay(ResourceReload arg2, Consumer<Optional<Throwable>> consumer) {
        this.resourceReload = arg2;
        this.optionalConsumer = consumer;
        SplashScreenTypes[] lvs = SplashScreenTypes.values();
        this.splashScreenTypes = lvs[(int)(System.currentTimeMillis() % (long)lvs.length)];
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        float g;
        int k = client.getWindow().getScaledWidth();
        int l = client.getWindow().getScaledHeight();
        RenderSystem.enableBlend();
        RenderSystem.blendEquation(32774);
        RenderSystem.blendFunc(770, 1);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
        RenderSystem.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
        RenderSystem.clear(16640, MinecraftClient.IS_SYSTEM_MAC);
        long m = Util.getMeasuringTimeMs();
        long n = m - this.field_38638;
        this.field_38638 = m;
        if (this.splashScreenStage == SplashScreenStage.INIT) {
            this.splashScreenStage = SplashScreenStage.FLY;
            this.field_38637 = 10.0f;
            this.field_38636 = -1L;
            return;
        }
        if (this.splashScreenStage == SplashScreenStage.FLY) {
            this.field_38637 -= (float)n / 500.0f;
            if (this.field_38637 <= 0.0f) {
                this.splashScreenStage = SplashScreenStage.WAIT_FOR_LOAD;
            }
        } else if (this.splashScreenStage == SplashScreenStage.WAIT_FOR_LOAD) {
            if (this.resourceReload.isComplete()) {
                this.field_38636 = m;
                this.soundInstance = new PositionedSoundInstance(new Identifier("gwwhit:awesome_intro"), SoundCategory.MASTER, 0.25f, 1.0f, false, 0, SoundInstance.AttenuationType.NONE, 0.0, 0.0, 0.0, true);
                client.getSoundManager().play(this.soundInstance);
                this.splashScreenStage = SplashScreenStage.TEXT;
            }
        } else if (!client.getSoundManager().isPlaying(this.soundInstance)) {
            client.setOverlay(null);
            try {
                this.resourceReload.throwException();
                this.optionalConsumer.accept(Optional.empty());
            }
            catch (Throwable throwable) {
                this.optionalConsumer.accept(Optional.of(throwable));
            }
            if (client.currentScreen != null) {
                client.currentScreen.init(client, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight());
            }
            this.splashScreenStage = SplashScreenStage.INIT;
        }
        Tessellator throwable = Tessellator.getInstance();
        BufferBuilder lv = throwable.getBuffer();
        lv.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        int o = MathHelper.clamp((int)(m - this.field_38636), 0, 255);
        if (this.field_38636 != -1L) {
            RenderSystem.setShaderTexture(0, MOJANG_TEXT);
            this.method_42981(matrices, lv, k / 2, l - l / 8, 208, 38, o);
        }
        throwable.draw();
        matrices.push();
        matrices.translate((float)k / 2.0f, (float)l / 2.0f, 0.0);
        switch (this.splashScreenTypes) {
            case CLASSIC: {
                g = 20.0f * this.field_38637;
                float h = 100.0f * MathHelper.sin(this.field_38637);
                matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(g));
                matrices.translate(h, 0.0, 0.0);
                float p = 1.0f / (2.0f * this.field_38637 + 1.0f);
                matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(1.5f * this.field_38637));
                matrices.scale(p, p, 1.0f);
                break;
            }
            case SPRING: {
                g = 40.0f * ((float)Math.exp(this.field_38637 / 3.0f) - 1.0f) * MathHelper.sin(this.field_38637);
                matrices.translate(g, 0.0, 0.0);
                break;
            }
            case SLOWDOWN: {
                g = (float)Math.exp(this.field_38637) - 1.0f;
                matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(g));
                break;
            }
            case REVERSE: {
                g = MathHelper.cos(this.field_38637 / 10.0f * (float)Math.PI);
                matrices.scale(g, g, 1.0f);
                break;
            }
            case GROW: {
                g = (1.0f - this.field_38637 / 10.0f) * 0.75f;
                float h = 2.0f * MathHelper.sin(g * (float)Math.PI);
                matrices.scale(h, h, 1.0f);
                break;
            }
        }
        RenderSystem.setShaderTexture(0, MOJANG_LOGO);
        lv.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        this.method_42981(matrices, lv, 0, 0, 78, 76, 255);
        throwable.draw();
        g = this.resourceReload.getProgress();
        this.field_38643 = MathHelper.clamp(this.field_38643 * 0.99f + g * 0.00999999f, 0.0f, 1.0f);
        this.method_42980(matrices, -39, 38, 39, 48, this.field_38643 != 1.0f ? 1.0f : 0.0f);
        matrices.pop();
    }

    private void method_42981(MatrixStack arg, BufferBuilder arg2, int i, int j, int k, int l, int m) {
        int n = k / 2;
        int o = l / 2;
        Matrix4f lv = arg.peek().getPositionMatrix();
        arg2.vertex(lv, i - n, j + o, 0.0f).texture(0.0f, 1.0f).color(255, 255, 255, m).next();
        arg2.vertex(lv, i + n, j + o, 0.0f).texture(1.0f, 1.0f).color(255, 255, 255, m).next();
        arg2.vertex(lv, i + n, j - o, 0.0f).texture(1.0f, 0.0f).color(255, 255, 255, m).next();
        arg2.vertex(lv, i - n, j - o, 0.0f).texture(0.0f, 0.0f).color(255, 255, 255, m).next();
    }

    private void method_42980(MatrixStack arg, int i, int j, int k, int l, float f) {
        int m = MathHelper.ceil((float)(k - i - 2) * this.field_38643);
        int n = Math.round(f * 255.0f);
        int o = ColorHelper.Argb.getArgb(n, 255, 255, 255);
        FoolsSplashOverlay.fill(arg, i + 2, j + 2, i + m, l - 2, o);
        FoolsSplashOverlay.fill(arg, i + 1, j, k - 1, j + 1, o);
        FoolsSplashOverlay.fill(arg, i + 1, l, k - 1, l - 1, o);
        FoolsSplashOverlay.fill(arg, i, j, i + 1, l, o);
        FoolsSplashOverlay.fill(arg, k, j, k - 1, l, o);
    }

    @Environment(value=EnvType.CLIENT)
    static enum SplashScreenStage {
        INIT,
        FLY,
        WAIT_FOR_LOAD,
        TEXT;

    }

    @Environment(value= EnvType.CLIENT)
    static enum SplashScreenTypes {
        CLASSIC,
        SPRING,
        SLOWDOWN,
        REVERSE,
        GROW;

    }
}
