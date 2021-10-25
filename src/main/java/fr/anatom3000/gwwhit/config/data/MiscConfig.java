package fr.anatom3000.gwwhit.config.data;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.fabricmc.loader.api.FabricLoader;

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

    @ConfigEntry.Gui.Tooltip
    public boolean owoifyer = false;
    @ConfigEntry.Gui.Tooltip
    public boolean rainbowConsole = false;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean python = false;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean scripting = false;
    @ConfigEntry.Gui.Tooltip
    public boolean increaseWorldHeight = false;
    @ConfigEntry.Gui.CollapsibleObject
    public Beemovie beemovie = new Beemovie();
    @ConfigEntry.Gui.CollapsibleObject
    public Fov fov = new Fov();
    @ConfigEntry.Gui.RequiresRestart
    public boolean debugMode; // set in constructor

    public static class Fov {
        public int max = 110;
        public int min = 30;
    }

    public static class Beemovie {
        @ConfigEntry.Gui.RequiresRestart
        public boolean replaceSplashes = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean replaceCredits = false; //TODO
        @ConfigEntry.Gui.RequiresRestart
        public boolean playNarrator = false;
    }
}
