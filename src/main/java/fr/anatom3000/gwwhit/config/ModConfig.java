package fr.anatom3000.gwwhit.config;

import com.google.common.collect.Lists;
import fr.anatom3000.gwwhit.GWWHIT;
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

@Config(name = GWWHIT.MOD_ID)
public class ModConfig implements ConfigData {
    @Gui.Excluded
    private static ModConfig CURRENT_CONFIG = null;
    
    @Gui.Excluded
    @AnnotationExclusionStrategy.Exclude //We make sure gson doesn't try to serialize this field since it's just a cache
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
        String config = GWWHIT.GSON.toJson(this);
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(config);
        return buf;
    }
    
    //Suggestion: rename to onLoad when adding other features similar to this
    public void setShader() {
        MinecraftClient mc = MinecraftClient.getInstance();
        Identifier shaderID = new Identifier(String.format("shaders/post/%s.json", ModConfig.getLoadedConfig().cosmetic.rendering.shader.toString().toLowerCase()));
        try {
            this.shader = new ShaderEffect(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), shaderID);
        } catch (IOException e) {
            this.shader = null;
        }
    }
    
    /*
        Tooltip policy: If it isn't self explanatory it's needed
    */
    
    //Config options
    @Gui.CollapsibleObject
    public Content content = new Content();
    @Gui.CollapsibleObject
    public Gameplay gameplay = new Gameplay();
    @Gui.CollapsibleObject
    public Cosmetic cosmetic = new Cosmetic();
    
    //Option classes
    
    public static class Content {
        @Gui.CollapsibleObject
        public Blocks blocks = new Blocks();
        @Gui.CollapsibleObject
        public MoreOres moreOres = new MoreOres();
        
        public static class Blocks {
            @Gui.CollapsibleObject
            public RandomisingBlock randomisingBlock = new RandomisingBlock();
            @Gui.CollapsibleObject
            public InfectedMassBlock infectedMassBlock = new InfectedMassBlock();
        
            public static class RandomisingBlock {
                public int ticksBetweenPlacements = 20;
                public int totalPlacements = 64;
                public boolean scrambleBlockState = false;
                @Gui.Tooltip
                public boolean deWaterlog = true;
                @Gui.Tooltip
                public List<String> blockBlacklist = Lists.newArrayList("minecraft:air", "minecraft:cave_air", "minecraft:void_air", "gwwhit:infected_mass", "gwwhit:randomising_block");
            }
    
            public static class InfectedMassBlock {
                public int ticksBetweenSpread = 20;
                @Gui.Tooltip
                public float globalSpreadChance = 75f;
                @Gui.Tooltip
                public float directionalSpreadChance = 20f;
                @Gui.Tooltip
                public List<String> spreadBlacklist = Lists.newArrayList("minecraft:air", "minecraft:cave_air", "minecraft:void_air", "gwwhit:infected_mass", "gwwhit:inert_infected_mass");
            }
        }
    
        public static class MoreOres {
            @Gui.RequiresRestart
            public boolean generateInWorld = false;
            @Gui.RequiresRestart
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
    
    public static class Gameplay {
        @Gui.CollapsibleObject
        public Drops drops = new Drops();
        
        public boolean stoneBlocksAreInfected = false;
        @Gui.Tooltip
        public boolean killCulling = false;
        
        public static class Drops {
            public boolean randomizedDrops = false;
            @Gui.Tooltip(count = 2)
            public boolean dreamLuck = false;
        }
    }
    
    public static class Cosmetic {
        @Gui.CollapsibleObject
        public Rendering rendering = new Rendering();
        @Gui.CollapsibleObject
        public Audio audio = new Audio();
        @Gui.Tooltip
        public boolean owoifyer = false;
        
        public static class Rendering {
            @Gui.CollapsibleObject
            public World world = new World();
            @Gui.CollapsibleObject
            public Entities entities = new Entities();
            public boolean unregisteredVersion = false;
            @Gui.EnumHandler(option = Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public Shaders shader = Shaders.NONE;
    
            @SuppressWarnings("unused")
            public enum Shaders {
                NONE,
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
    
            public static class World {
                @Gui.Tooltip
                public boolean smallBlocks = false;
                @Gui.Tooltip
                public boolean spin = false;
                @Gui.Tooltip
                public float matrixScale = 1;
            }
        
            public static class Entities {
                @Gui.Tooltip
                public boolean deadmauEars = false;
                @Gui.Tooltip
                public boolean dinnerboneEntities = false;
            }
        }
        
        public static class Audio {
            @Gui.Tooltip( count = 2 )
            public boolean mojaaaangStartupSound = false;
            @Gui.Tooltip
            public boolean blyatSounds = false;
            @Gui.Tooltip
            @Gui.CollapsibleObject
            public WhatsAppWhistle whatsAppWhistle = new WhatsAppWhistle();
    
            public static class WhatsAppWhistle {
                @Gui.Tooltip
                public boolean enabled = false;
                public float volume = 1f;
            }
        }
    }
}
