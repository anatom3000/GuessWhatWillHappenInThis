package fr.anatom3000.gwwhit.config;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderEffect;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

@Config(name = GuessWhatWillHappenInThisMod.MOD_ID)
public class ModConfig implements ConfigData {

    @Gui.Excluded
    private static ModConfig CURRENT_CONFIG = null;
      
    @Gui.Excluded
    public ShaderEffect shader = null;
    
    private ModConfig() {}
    
    public static ModConfig getLoadedConfig() {
        if (CURRENT_CONFIG == null) CURRENT_CONFIG = getHolder().getConfig();
        
        return CURRENT_CONFIG;
    }
    
    public static void loadConfig(@Nullable ModConfig config) {
        if (config == null) config = getHolder().getConfig();
      
        CURRENT_CONFIG = config;
    }
    
    public static ConfigHolder<ModConfig> getHolder() {
        return AutoConfig.getConfigHolder(ModConfig.class);
    }
    
    public PacketByteBuf toPacketByteBuf() {
        String config = GuessWhatWillHappenInThisMod.JANKSON.toJson(this).toJson();
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(config);
        return buf;
    }
    
    @Deprecated
    public static ModConfig getInstance() {
        return getLoadedConfig();
    }
    
    @Deprecated
    public static void setInstance(@Nullable ModConfig config) {
        loadConfig(config);
    }

    public void setShader() {
        MinecraftClient mc = MinecraftClient.getInstance();
        Identifier shaderID = new Identifier(String.format("shaders/post/%s.json", ModConfig.getInstance().rendering.other.shader.toString().toLowerCase()));
        try {
            ShaderEffect shader = new ShaderEffect(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), shaderID);
            this.shader = shader;
        } catch (IOException e) {
            this.shader = null;
        }
    }
    
    @Deprecated
    public PacketByteBuf getSyncable() {
        return toPacketByteBuf();
    }
    
    @Gui.Tooltip
    @Gui.CollapsibleObject
    public Blocks blocks = new Blocks();

    @Gui.Tooltip
    @Gui.CollapsibleObject
    public Drops drops = new Drops();
    
    @Gui.Tooltip
    @Gui.CollapsibleObject
    public Rendering rendering = new Rendering();
    
    @Gui.Tooltip
    @Gui.CollapsibleObject
    public Misc misc = new Misc();


    
    public static class Misc {
        @Gui.Tooltip
        public boolean killCulling = false;
        @Gui.Tooltip
        public boolean owoifyer = false;

        @Gui.Tooltip
        @Gui.CollapsibleObject
        public WhatsAppWhistle whatsAppWhistle = new WhatsAppWhistle();

        public static class WhatsAppWhistle {
            public boolean playWhatsAppWhistleOnChat = false;

            public float volume = 1f;
        }
    }
    
    public static class Drops {
        //public boolean randomizedDrops = false; //crashes
        @Gui.Tooltip(count = 2)
        public boolean dreamLuck = false;
    }

    public static class Blocks {
        @Gui.Tooltip
        public boolean stoneBlocksAreInfected = false;
    }
    
    public static class Rendering {

        public enum Shaders {
            I_Hate_Cool_Features,
            Notch,
            Bumpy,
            Blobs,
            Pencil,
            Deconverge,
            Flip,
            Invert,
            NTSC,
            Outline,
            Phosphor,
            Sobel,
            Bits,
            Desaturate,
            Blur,
            Creeper,
            Spider,
            Wobble,
            Green
        }
      
        @Gui.Tooltip(count = 2)
        @Gui.CollapsibleObject
        public Matrices matrices = new Matrices();
        @Gui.Tooltip
        @Gui.CollapsibleObject
        public Other other = new Other();
        
        public static class Matrices {
            @Gui.Tooltip
            public boolean smallBlocks = false;
            @Gui.Tooltip
            public boolean spin = false;
            @Gui.Tooltip
            public float matrixScale = 1;
        }
        
        public static class Other {
            @Gui.Tooltip
            public boolean deadmauEars = false;
            @Gui.Tooltip
            public boolean dinnerboneEntities = false;
            @Gui.Tooltip
            public boolean unregisteredVersion = false;

            public Shaders shader = Shaders.I_Hate_Cool_Features;
        }
    }
}
