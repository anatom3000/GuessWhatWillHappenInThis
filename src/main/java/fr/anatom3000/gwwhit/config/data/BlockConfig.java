package fr.anatom3000.gwwhit.config.data;

import com.google.common.collect.Lists;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.List;

@SuppressWarnings("CanBeFinal") // Shut up code inspection
@Config(name = "blocks")
public class BlockConfig implements ConfigData {
    BlockConfig(){}

    @ConfigEntry.Gui.CollapsibleObject
    public RandomisingBlock randomisingBlock = new RandomisingBlock();
    @ConfigEntry.Gui.CollapsibleObject
    public InfectedMassBlock infectedMassBlock = new InfectedMassBlock();

    public static class RandomisingBlock {
        public int ticksBetweenPlacements = 20;
        public int totalPlacements = 64;
        public boolean scrambleBlockState = false;
        @ConfigEntry.Gui.Tooltip
        public boolean deWaterlog = true;
        @ConfigEntry.Gui.Tooltip
        public List<String> blockBlacklist = Lists.newArrayList("minecraft:air", "minecraft:cave_air", "minecraft:void_air", "gwwhit:infected_mass", "gwwhit:randomising_block");
    }

    public static class InfectedMassBlock {
        public int ticksBetweenSpread = 20;
        @ConfigEntry.Gui.Tooltip
        public float globalSpreadChance = 75f;
        @ConfigEntry.Gui.Tooltip
        public float directionalSpreadChance = 20f;
        @ConfigEntry.Gui.Tooltip
        public List<String> spreadBlacklist = Lists.newArrayList("minecraft:air", "minecraft:cave_air", "minecraft:void_air", "gwwhit:infected_mass", "gwwhit:inert_infected_mass");
    }
}
