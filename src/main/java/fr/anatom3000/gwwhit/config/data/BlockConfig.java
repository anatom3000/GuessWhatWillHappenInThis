package fr.anatom3000.gwwhit.config.data;

import com.google.common.collect.Lists;
import fr.anatom3000.gwwhit.config.SyncOptions;
import fr.anatom3000.gwwhit.util.TabType;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;

import java.util.List;

import static fr.anatom3000.gwwhit.config.SyncOptions.GROUP;
import static fr.anatom3000.gwwhit.config.SyncOptions.SERVER;

@SuppressWarnings("CanBeFinal") // Shut up code inspection
@Config(name = "blocks")
public class BlockConfig implements ConfigData {
    BlockConfig(){}

    @SyncOptions(GROUP) @CollapsibleObject public RandomisingBlock randomisingBlock = new RandomisingBlock();
    @SyncOptions(GROUP) @CollapsibleObject public InfectedMassBlock infectedMassBlock = new InfectedMassBlock();

    @ConfigEntry.Gui.TransitiveObject
    public ColorConfig colors = new ColorConfig();

    public static class RandomisingBlock {
        @SyncOptions(SERVER) public int ticksBetweenPlacements = 20;
        @SyncOptions(SERVER) public int totalPlacements = 64;
        @SyncOptions(SERVER) public boolean scrambleBlockState = false;
        @SyncOptions(SERVER) @Tooltip public boolean deWaterlog = true;
        @SyncOptions(SERVER) @Tooltip public List<String> blockBlacklist = Lists.newArrayList("minecraft:air", "minecraft:cave_air", "minecraft:void_air", "gwwhit:infected_mass", "gwwhit:randomising_block");
    }

    public static class InfectedMassBlock {
        @SyncOptions(SERVER) public int ticksBetweenSpread = 20;
        @SyncOptions(SERVER) @Tooltip public float globalSpreadChance = 75f;
        @SyncOptions(SERVER) @Tooltip public float directionalSpreadChance = 20f;
        @SyncOptions(SERVER) @Tooltip public List<String> spreadBlacklist = Lists.newArrayList("minecraft:air", "minecraft:cave_air", "minecraft:void_air", "gwwhit:infected_mass", "gwwhit:inert_infected_mass");
    }

    public static class ColorConfig {
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public TabType tab = TabType.NONE;
    }
}
