package fr.anatom3000.gwwhit.config.data;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "moreOres")
public class MoreOresConfig implements ConfigData {
    MoreOresConfig(){}

    @ConfigEntry.Gui.RequiresRestart
    public boolean generateInWorld = false;
    @ConfigEntry.Gui.RequiresRestart
    public int oresCount = 100;
    @ConfigEntry.Gui.RequiresRestart
    public int seed = 1024;
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public Tab tab = Tab.NONE;

    @SuppressWarnings("unused")
    public enum Tab {
        NONE,
        MAIN,
        SEPARATE
    }
}
