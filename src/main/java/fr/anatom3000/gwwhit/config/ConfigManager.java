package fr.anatom3000.gwwhit.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.data.MainConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderEffect;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy()).setPrettyPrinting().create();
    public static ShaderEffect shader = null;
    private static MainConfig CURRENT_CONFIG = null;

    private ConfigManager() {
    }

    public static MainConfig getLoadedConfig() {
        if (CURRENT_CONFIG == null) {
            AutoConfig.register(MainConfig.class, PartitioningSerializer.wrap((definition, configClass) -> new GsonConfigSerializer<>(definition, configClass, GSON)));
            GWWHIT.LOGGER.info("Gwwhit config registered!");
            CURRENT_CONFIG = getHolder().getConfig();
        }

        return CURRENT_CONFIG;
    }

    public static void loadConfig(@Nullable MainConfig config) {
        if (config == null) config = getHolder().getConfig();

        CURRENT_CONFIG = config;
    }

    public static ConfigHolder<MainConfig> getHolder() {
        return AutoConfig.getConfigHolder(MainConfig.class);
    }

    public static PacketByteBuf toPacketByteBuf() {
        String version = FabricLoader.getInstance().getModContainer(GWWHIT.MOD_ID).orElseThrow().getMetadata().getVersion().getFriendlyString();
        String config = GWWHIT.GSON.toJson(getLoadedConfig());
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(version);
        buf.writeString(config);
        return buf;
    }

    //Suggestion: rename to onLoad when adding other features similar to this
    public static void setShader() {
        MinecraftClient mc = MinecraftClient.getInstance();
        Identifier shaderID = new Identifier(String.format("shaders/post/%s.json", ConfigManager.getLoadedConfig().rendering.shader.toString().toLowerCase()));
        try {
            shader = new ShaderEffect(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), shaderID);
        } catch (IOException e) {
            shader = null;
        }
    }

    public static void load() {
        getHolder().load();
    }
}
