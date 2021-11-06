package fr.anatom3000.gwwhit.config.data;

import fr.anatom3000.gwwhit.config.SyncOptions;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.EnumHandler;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;

import static fr.anatom3000.gwwhit.config.SyncOptions.*;

@SuppressWarnings("CanBeFinal") // Shut up code inspection
@Config(name = "rendering")
public class RenderingConfig implements ConfigData {
    RenderingConfig(){}

    @SyncOptions(GROUP) @CollapsibleObject public World world = new World();
    @SyncOptions(GROUP) @CollapsibleObject public Entities entities = new Entities();
    @SyncOptions(CLIENT | SYNCED) public boolean unregisteredVersion = false;
    @SyncOptions(CLIENT | SYNCED) @EnumHandler public Shaders shader = Shaders.NONE;
    @SyncOptions(CLIENT | SYNCED) @Tooltip public boolean itemUseRomanNumerals;

    public static class World {
        @SyncOptions(CLIENT | SYNCED) @Tooltip public boolean smallBlocks = false;
        @SyncOptions(CLIENT | SYNCED) @Tooltip public boolean spin = false;
        @SyncOptions(CLIENT | SYNCED) public float matrixScale = 1;
        @SyncOptions(CLIENT | SYNCED) public boolean allowMatrixLevels = true;
        @SyncOptions(CLIENT | SYNCED) public float matrixTranslationScale = 1;
        @SyncOptions(CLIENT | SYNCED) public boolean nauseaOverride = false;
    }

    public static class Entities {
        @SyncOptions(CLIENT | SYNCED) @Tooltip public boolean deadmauEars = false;
        @SyncOptions(CLIENT | SYNCED) @Tooltip public boolean dinnerboneEntities = false;
    }

    @SuppressWarnings("unused") // Used dynamically
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
        //BLUR, //Makes the screen black probably broken
        CREEPER,
        SPIDER,
        WOBBLE,
        GREEN
    }
}
