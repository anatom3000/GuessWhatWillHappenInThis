package fr.anatom3000.gwwhit.config.data;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "rendering")
public class RenderingConfig implements ConfigData {
    RenderingConfig(){}

    @ConfigEntry.Gui.CollapsibleObject
    public World world = new World();
    @ConfigEntry.Gui.CollapsibleObject
    public Entities entities = new Entities();
    public boolean unregisteredVersion = false;
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public Shaders shader = Shaders.NONE;
    @ConfigEntry.Gui.Tooltip
    public boolean itemUseRomanNumerals;

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
        @ConfigEntry.Gui.Tooltip
        public boolean smallBlocks = false;
        @ConfigEntry.Gui.Tooltip
        public boolean spin = false;
        @ConfigEntry.Gui.Tooltip
        public float matrixScale = 1;
    }

    public static class Entities {
        @ConfigEntry.Gui.Tooltip
        public boolean deadmauEars = false;
        @ConfigEntry.Gui.Tooltip
        public boolean dinnerboneEntities = false;
    }
}
