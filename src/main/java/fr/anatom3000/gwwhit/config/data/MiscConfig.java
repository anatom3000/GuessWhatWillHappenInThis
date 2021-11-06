package fr.anatom3000.gwwhit.config.data;

import fr.anatom3000.gwwhit.config.SyncOptions;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.RequiresRestart;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;
import net.fabricmc.loader.api.FabricLoader;

import static fr.anatom3000.gwwhit.config.SyncOptions.*;

@SuppressWarnings("CanBeFinal") // Shut up code inspection
@Config(name = "misc")
public class MiscConfig implements ConfigData {
    MiscConfig(){
        //Check if we're running in dev and ignore error if fabric isn't loaded
        try {
            debugMode = FabricLoader.getInstance().isDevelopmentEnvironment();
        } catch (NullPointerException e) {
            debugMode = false;
        }
    }

    @SyncOptions(CLIENT | SYNCED) @Tooltip public boolean owoifyer = false;
    @SyncOptions(CLIENT | CHECKED) @RequiresRestart public boolean debugMode; // set in constructor
    @SyncOptions(BOTH | CHECKED) @Tooltip @RequiresRestart public boolean python = false;
    @SyncOptions(BOTH | CHECKED) @Tooltip @RequiresRestart public boolean scripting = false;
    @SyncOptions(SERVER) @Tooltip public boolean increaseWorldHeight = false;
    @SyncOptions(BOTH) @Tooltip public boolean rainbowConsole = false;
    @SyncOptions(GROUP) @CollapsibleObject public Beemovie beemovie = new Beemovie();
    @SyncOptions(GROUP) @CollapsibleObject public Fov fov = new Fov();

    public static class Fov {
        @SyncOptions(CLIENT | SYNCED) public int max = 110;
        @SyncOptions(CLIENT | SYNCED) public int min = 30;
    }

    public static class Beemovie {
        @SyncOptions(CLIENT) @RequiresRestart public boolean replaceSplashes = true;
        @SyncOptions(CLIENT) @RequiresRestart public boolean playNarrator = false;
        @SyncOptions(NONE) @RequiresRestart public boolean replaceCredits = false; //TODO
    }
}
