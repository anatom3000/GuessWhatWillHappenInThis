package fr.anatom3000.gwwhit.config.data;

import com.mojang.datafixers.util.Either;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.fabricmc.loader.api.FabricLoader;

import java.util.Optional;

@Config(name = "misc")
public class MiscConfig implements ConfigData {
    MiscConfig(){}

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
    public Fov fov = new Fov();
    @ConfigEntry.Gui.RequiresRestart
    public boolean debugMode = FabricLoader.getInstance().isDevelopmentEnvironment();

    public static class Fov {
        @ConfigEntry.Gui.RequiresRestart
        public int max = 110;
        @ConfigEntry.Gui.RequiresRestart
        public int min = 30;
    }
}
