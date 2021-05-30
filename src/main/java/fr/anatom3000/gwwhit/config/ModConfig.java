package fr.anatom3000.gwwhit.config;

import com.google.common.collect.Lists;
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
import java.util.List;

@Config(name = GuessWhatWillHappenInThisMod.MOD_ID)
public final class ModConfig implements ConfigData {
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
        String config = GuessWhatWillHappenInThisMod.GSON.toJson(this);
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(config);
        return buf;
    }
    
    //Suggestion: rename to onLoad when adding other features similar to this
    public void setShader() {
        MinecraftClient mc = MinecraftClient.getInstance();
        Identifier shaderID = new Identifier(String.format("shaders/post/%s.json", ModConfig.getLoadedConfig().rendering.other.shader.toString().toLowerCase()));
        try {
            this.shader = new ShaderEffect(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), shaderID);
        } catch (IOException e) {
            this.shader = null;
        }
    }
    
    /**
     * @deprecated Use {@link ModConfig#getLoadedConfig()}
     */
    @Deprecated
    public static ModConfig getInstance() {
        return getLoadedConfig();
    }
    
    /**
     * @deprecated Use {@link ModConfig#loadConfig(ModConfig)}
     */
    @Deprecated
    public static void setInstance(@Nullable ModConfig config) {
        loadConfig(config);
    }
    
    /**
     * @deprecated Use {@link ModConfig#toPacketByteBuf()}
     */
    @Deprecated
    public PacketByteBuf getSyncable() {
        return toPacketByteBuf();
    }
    
    
    //Config options
    
    @Gui.CollapsibleObject
    public Drops drops = new Drops();
    
    @Gui.CollapsibleObject
    public Rendering rendering = new Rendering();
    
    @Gui.CollapsibleObject
    public Misc misc = new Misc();
    
    @Gui.CollapsibleObject
    public Blocks blocks = new Blocks();
    
    @Gui.CollapsibleObject
    public Packs packs = new Packs();
    
    //Option classes
    
    public static class Blocks {
        @Gui.CollapsibleObject
        public RandomisingBlock randomisingBlock = new RandomisingBlock();
        
        public static class RandomisingBlock {
            @Gui.Tooltip
            public int ticksBetweenPlacements = 20;
            @Gui.Tooltip
            public int totalPlacements = 64;
            @Gui.Tooltip
            public boolean scrambleBlockState = false;
            @Gui.Tooltip
            public boolean deWaterlog = true;
            @Gui.Tooltip
            public List<String> blockBlackList = Lists.newArrayList("gwwhit:infected_mass", "minecraft:air", "minecraft:cave_air", "gwwhit:randomising_block");
        }
    }
    
    public static class Packs {
        @Gui.CollapsibleObject
        public MoreOres moreOres = new MoreOres();
    
        public static class MoreOres {
            @Gui.Tooltip
            @Gui.RequiresRestart
            public boolean generateInWorld = false;
            @Gui.RequiresRestart
            @Gui.Tooltip
            @Gui.EnumHandler(option = Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public Tab tab = Tab.NONE;
    
            @SuppressWarnings("unused")
            public enum Tab {
                NONE,
                MAIN,
                SEPARATE
            }
        }
    }
    
    public static class Misc {
        @Gui.Tooltip
        public boolean killCulling = false;
        @Gui.Tooltip
        public boolean owoifyer = false;
        
        @Gui.CollapsibleObject
        public WhatsAppWhistle whatsAppWhistle = new WhatsAppWhistle();

        public static class WhatsAppWhistle {
            @Gui.Tooltip
            public boolean playWhatsAppWhistleOnChat = false;
            public float volume = 1f;
        }
    }
    
    public static class Drops {
        //public boolean randomizedDrops = false; //crashes
        @Gui.Tooltip(count = 2)
        public boolean dreamLuck = false;
    }
    
    public static class Rendering {

        @SuppressWarnings("unused")
        public enum Shaders {
            I_HATE_COOL_FEATURES,
            NOTCH,
            BUMPY,
            BLOBS,
            PENCIL,
            DECONVERGE,
            FLIP,
            INVERT,
            NTSC,
            OUTLINE,
            PHOSPHOR,
            SOBEL,
            BITS,
            DESATURATE,
            BLUR,
            CREEPER,
            SPIDER,
            WOBBLE,
            GREEN
        }
      
        @Gui.Tooltip
        @Gui.CollapsibleObject
        public Matrices matrices = new Matrices();
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
            @Gui.EnumHandler(option = Gui.EnumHandler.EnumDisplayOption.BUTTON)
            @Gui.Tooltip
            public Shaders shader = Shaders.I_HATE_COOL_FEATURES;
        }
    }
}
