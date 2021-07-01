package fr.anatom3000.gwwhit.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.anatom3000.gwwhit.GWWHIT;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderEffect;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class ConfigManager {
    private static ModConfig CURRENT_CONFIG = null;
    public static ShaderEffect shader = null;
    private static final Gson GSON = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy()).setPrettyPrinting().create();
    
    private ConfigManager() {}
    
    public static ModConfig getLoadedConfig() {
        if (CURRENT_CONFIG == null) {
            AutoConfig.register(ModConfig.class, (definition, configClass) -> new GsonConfigSerializer<>(definition, configClass, GSON));
            GWWHIT.LOGGER.info("Gwwhit config registered!");
            CURRENT_CONFIG = getHolder().getConfig();
        }
        
        return CURRENT_CONFIG;
    }
    
    public static void loadConfig(@Nullable ModConfig config) {
        if (config == null) config = getHolder().getConfig();
      
        CURRENT_CONFIG = config;
    }

    public static ConfigHolder<ModConfig> getHolder() {
        return AutoConfig.getConfigHolder(ModConfig.class);
    }
    
    public static PacketByteBuf toPacketByteBuf() {
        String config = GWWHIT.GSON.toJson(getLoadedConfig());
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(config);
        return buf;
    }
    
    //Suggestion: rename to onLoad when adding other features similar to this
    public static void setShader() {
        MinecraftClient mc = MinecraftClient.getInstance();
        Identifier shaderID = new Identifier(String.format("shaders/post/%s.json", ConfigManager.getLoadedConfig().cosmetic.rendering.shader.toString().toLowerCase()));
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
