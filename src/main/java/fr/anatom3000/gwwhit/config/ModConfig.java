package fr.anatom3000.gwwhit.config;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import org.jetbrains.annotations.Nullable;

@Config(name = GuessWhatWillHappenInThisMod.MOD_ID)
public class ModConfig implements ConfigData {
    private static final Jankson jankson = Jankson.builder().build();
    private static ModConfig SERVER_CONFIG = null;
    
    public static ModConfig getInstance() {
        return SERVER_CONFIG == null ? AutoConfig.getConfigHolder(ModConfig.class).getConfig() : SERVER_CONFIG;
    }
    
    public static ConfigHolder<ModConfig> getHolder() {
        return AutoConfig.getConfigHolder(ModConfig.class);
    }
    
    public PacketByteBuf getSyncable() {
        String config = jankson.toJson(this).toJson();
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(config);
        return buf;
    }
    
    public static void setInstance(@Nullable ModConfig config) {
        SERVER_CONFIG = config;
    }
    
    private ModConfig() {}
    
    @Gui.CollapsibleObject
    public Drops drops = new Drops();
    
    @Gui.CollapsibleObject
    public Rendering rendering = new Rendering();
    
    @Gui.CollapsibleObject
    public Misc misc = new Misc();
    
    
    
    
    public static class Misc {
        public boolean killCulling = false;
        public boolean owoifyer = false;
    }
    
    public static class Drops {
        //public boolean randomizedDrops = false; //crashes
        public boolean dreamLuck = false;
    }
    
    public static class Rendering {
        @Gui.CollapsibleObject
        public Matrices matrices = new Matrices();
        @Gui.CollapsibleObject
        public Other other = new Other();
        
        public static class Matrices {
            public boolean smallBlocks = false;
            public boolean spin = false;
        }
        
        public static class Other {
            public boolean deadmauEars = false;
            public boolean dinnerboneEntities = false;
            public boolean unregisteredVersion = false;
        }
    }
}
