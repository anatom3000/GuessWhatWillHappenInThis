package fr.anatom3000.gwwhit.config.data;

import fr.anatom3000.gwwhit.config.SyncOptions;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.RequiresRestart;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.EnumHandler;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.EnumHandler.EnumDisplayOption;

import static fr.anatom3000.gwwhit.config.SyncOptions.*;

@Config(name = "moreOres")
public class MoreOresConfig implements ConfigData {
    MoreOresConfig(){}

    @SyncOptions(SERVER) @RequiresRestart public boolean generateInWorld = false;
    @SyncOptions(BOTH | CHECKED) @RequiresRestart public int oresCount = 100;
    @SyncOptions(BOTH | CHECKED) @RequiresRestart public int oreNameLengthMin = 3;
    @SyncOptions(BOTH | CHECKED) @RequiresRestart public int oreNameLengthMax = 5;
    @SyncOptions(BOTH | CHECKED) @RequiresRestart public int seed = 1024;
    @SyncOptions(BOTH | CHECKED) @RequiresRestart @EnumHandler(option = EnumDisplayOption.BUTTON) public Tab tab = Tab.NONE;

    public enum Tab {
        NONE,
        MAIN,
        SEPARATE
    }
}
