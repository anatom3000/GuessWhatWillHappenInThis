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
public final class ModConfig implements ConfigData {
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
    public final Content content = new Content();
    @Gui.CollapsibleObject
    public final Gameplay gameplay = new Gameplay();
    @Gui.CollapsibleObject
    public final Cosmetic cosmetic = new Cosmetic();
    
    //Option classes
    
    public static final class Content {
        @Gui.CollapsibleObject
        public final Blocks blocks = new Blocks();
        @Gui.CollapsibleObject
        public final MoreOres moreOres = new MoreOres();
        
        public static final class Blocks {
            @Gui.CollapsibleObject
            public final RandomisingBlock randomisingBlock = new RandomisingBlock();
            @Gui.CollapsibleObject
            public final InfectedMassBlock infectedMassBlock = new InfectedMassBlock();
        
            public static final class RandomisingBlock {
                public final int ticksBetweenPlacements = 20;
                public final int totalPlacements = 64;
                public final boolean scrambleBlockState = false;
                @Gui.Tooltip
                public final boolean deWaterlog = true;
                @Gui.Tooltip
                public final List<String> blockBlacklist = Lists.newArrayList("minecraft:air", "minecraft:cave_air", "minecraft:void_air", "gwwhit:infected_mass", "gwwhit:randomising_block");
            }
    
            public static final class InfectedMassBlock {
                public final int ticksBetweenSpread = 20;
                @Gui.Tooltip
                public final float globalSpreadChance = 75f;
                @Gui.Tooltip
                public final float directionalSpreadChance = 20f;
                @Gui.Tooltip
                public final List<String> spreadBlacklist = Lists.newArrayList("minecraft:air", "minecraft:cave_air", "minecraft:void_air", "gwwhit:infected_mass", "gwwhit:inert_infected_mass");
            }
        }
    
        public static class MoreOres {
            @Gui.RequiresRestart
            public final boolean generateInWorld = false;
            @Gui.RequiresRestart
            @Gui.EnumHandler(option = Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public final Tab tab = Tab.NONE;
        
            @SuppressWarnings("unused")
            public enum Tab {
                NONE,
                MAIN,
                SEPARATE
            }
        }
    }
    
    public static final class Gameplay {
        @Gui.CollapsibleObject
        public final Drops drops = new Drops();
        
        public final boolean stoneBlocksAreInfected = false;
        @Gui.Tooltip
        public final boolean killCulling = false;
        
        public static final class Drops {
            //public boolean randomizedDrops = false; //crashes
            @Gui.Tooltip(count = 2)
            public final boolean dreamLuck = false;
        }
    }
    
    public static final class Cosmetic {
        @Gui.CollapsibleObject
        public final Rendering rendering = new Rendering();
        @Gui.CollapsibleObject
        public final Audio audio = new Audio();
        @Gui.Tooltip
        public final boolean owoifyer = false;
        
        public static final class Rendering {
            @Gui.CollapsibleObject
            public final World world = new World();
            @Gui.CollapsibleObject
            public final Entities entities = new Entities();
            public final boolean unregisteredVersion = false;
            @Gui.EnumHandler(option = Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public final Shaders shader = Shaders.NONE;
    
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
                public final boolean smallBlocks = false;
                @Gui.Tooltip
                public final boolean spin = false;
                @Gui.Tooltip
                public final float matrixScale = 1;
            }
        
            public static class Entities {
                @Gui.Tooltip
                public final boolean deadmauEars = false;
                @Gui.Tooltip
                public final boolean dinnerboneEntities = false;
            }
        }
        
        public static final class Audio {
            @Gui.Tooltip( count = 2 )
            public final boolean mojaaaangStartupSound = false;
            @Gui.Tooltip
            public final boolean blyatSounds = false;
            @Gui.Tooltip
            @Gui.CollapsibleObject
            public final WhatsAppWhistle whatsAppWhistle = new WhatsAppWhistle();
    
            public static class WhatsAppWhistle {
                @Gui.Tooltip
                public final boolean enabled = false;
                public final float volume = 1f;
            }
        }
    }
}
