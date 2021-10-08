package fr.anatom3000.gwwhit.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.data.MainConfig;
import fr.anatom3000.gwwhit.config.data.RenderingConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderEffect;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy()).setPrettyPrinting().create();
    public static ShaderEffect shader = null;
    private static MainConfig activeConfig = null;

    private ConfigManager() {
    }

    public static MainConfig getActiveConfig() {
        if (activeConfig == null) {
            AutoConfig.register(MainConfig.class, PartitioningSerializer.wrap((definition, configClass) -> new GsonConfigSerializer<>(definition, configClass, GSON)));
            GWWHIT.LOGGER.info("Gwwhit config registered!");
            activeConfig = getHolder().get();
        }

        return activeConfig;
    }

    public static void setActiveConfig(@Nullable MainConfig config) {
        if (config == null) config = getHolder().get();

        activeConfig = config;
    }

    public static ConfigHolder<MainConfig> getHolder() {
        return AutoConfig.getConfigHolder(MainConfig.class);
    }

    public static void fromPacket(String version, String configData) {
        MainConfig config = null;
        try {
            if (GWWHIT.MOD_VERSION.equals(version))
                config = GWWHIT.GSON.fromJson(configData, MainConfig.class);
            else
                throw new IllegalStateException("Non matching gwwhit versions!");
        } catch (JsonSyntaxException e) {
            GWWHIT.LOGGER.error("Can't parse config! Falling back to local", e);
        }

        ConfigManager.setActiveConfig(config);
        ConfigManager.onSync();
        MinecraftClient.getInstance().worldRenderer.reload();
    }

    public static PacketByteBuf toPacketByteBuf() {
        String config = GWWHIT.GSON.toJson(getActiveConfig());
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(GWWHIT.MOD_VERSION);
        buf.writeString(config);
        return buf;
    }

    public static void onSync() {
        MinecraftClient mc = MinecraftClient.getInstance();
        var configShader = ConfigManager.getActiveConfig().rendering.shader;
        if (configShader == RenderingConfig.Shaders.NONE) {
            shader = null;
            return;
        }

        Identifier shaderID = new Identifier(String.format("shaders/post/%s.json", configShader.toString().toLowerCase()));
        try {
            shader = new ShaderEffect(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), shaderID);
        } catch (IOException e) {
            shader = null;
        }
    }

    public static void reloadLocalConfig() {
        getHolder().load();
        activeConfig = getHolder().get();
    }
}
