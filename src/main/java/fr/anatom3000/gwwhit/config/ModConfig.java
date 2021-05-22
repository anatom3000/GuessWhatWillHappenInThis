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
    private static ModConfig SERVER_CONFIG = null;

    @Gui.Excluded
    public ShaderEffect shader = null;

    public static ModConfig getInstance() {
        return SERVER_CONFIG == null ? AutoConfig.getConfigHolder(ModConfig.class).getConfig() : SERVER_CONFIG;
    }
    
    public static ConfigHolder<ModConfig> getHolder() {
        return AutoConfig.getConfigHolder(ModConfig.class);
    }
    
    public PacketByteBuf getSyncable() {
        String config = GuessWhatWillHappenInThisMod.JANKSON.toJson(this).toJson();
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(config);
        return buf;
    }
    
    public static void setInstance(@Nullable ModConfig config) {
        SERVER_CONFIG = config;
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

        @Gui.CollapsibleObject
        public Matrices matrices = new Matrices();
        @Gui.CollapsibleObject
        public Other other = new Other();
        
        public static class Matrices {
            public boolean smallBlocks = false;
            public boolean spin = false;
            public float matrixScale = 1;
        }
        
        public static class Other {
            public boolean deadmauEars = false;
            public boolean dinnerboneEntities = false;
            public boolean unregisteredVersion = false;

            public Shaders shader = Shaders.I_Hate_Cool_Features;
        }
    }
}
