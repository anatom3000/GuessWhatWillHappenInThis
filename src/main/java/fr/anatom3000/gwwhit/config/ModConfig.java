package fr.anatom3000.gwwhit.config;

import com.google.common.collect.Lists;
import fr.anatom3000.gwwhit.GWWHIT;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.List;

@SuppressWarnings("unused")
@Config(name = GWWHIT.MOD_ID)
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    public Content content = new Content();
    @ConfigEntry.Gui.CollapsibleObject
    public Gameplay gameplay = new Gameplay();
    @ConfigEntry.Gui.CollapsibleObject
    public Cosmetic cosmetic = new Cosmetic();

    //Option classes

    public static class Content {
        @ConfigEntry.Gui.CollapsibleObject
        public Blocks blocks = new Blocks();
        @ConfigEntry.Gui.CollapsibleObject
        public MoreOres moreOres = new MoreOres();
        @ConfigEntry.Gui.Tooltip
        public boolean increaseWorldHeight = false;
        @ConfigEntry.Gui.Tooltip()
        @ConfigEntry.Gui.RequiresRestart()
        public boolean python = false;

        public static class Blocks {
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

        public static class MoreOres {
            @ConfigEntry.Gui.RequiresRestart
            public boolean generateInWorld = false;
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
    }

    public static class Gameplay {
        @ConfigEntry.Gui.CollapsibleObject
        public Drops drops = new Drops();
        @ConfigEntry.Gui.CollapsibleObject
        public Items items = new Items();
        public boolean stoneBlocksAreInfected = false;
        public boolean mobsMayExplode = false;
        @ConfigEntry.Gui.Tooltip
        public boolean killCulling = false;

		public static class Items {
            @ConfigEntry.Gui.RequiresRestart
            public boolean everythingIsEdible = false;
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.Gui.RequiresRestart
            public boolean hiddenItemsTab = false;
            @ConfigEntry.Gui.RequiresRestart
            @ConfigEntry.BoundedDiscrete(min = 1, max = 64)
            public int maxStackSize = 64;
            @ConfigEntry.Gui.Tooltip
            public boolean noHardcodedItemCooldown = false;
        }
        
        public static class Drops {
            public boolean randomizedDrops = false;
            @ConfigEntry.Gui.Tooltip(count = 2)
            public boolean dreamLuck = false;
        }
    }

    public static class Cosmetic {
        @ConfigEntry.Gui.CollapsibleObject
        public Rendering rendering = new Rendering();
        @ConfigEntry.Gui.CollapsibleObject
        public Audio audio = new Audio();
        @ConfigEntry.Gui.Tooltip
        public boolean owoifyer = false;

        public static class Rendering {
            @ConfigEntry.Gui.CollapsibleObject
            public World world = new World();
            @ConfigEntry.Gui.CollapsibleObject
            public Entities entities = new Entities();
            public boolean unregisteredVersion = false;
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public Shaders shader = Shaders.NONE;

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

        public static class Audio {
            @ConfigEntry.Gui.Tooltip
            public boolean mojaaaangStartupSound = false;
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
            public SoundReplacement soundReplacement = SoundReplacement.None;
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.Gui.CollapsibleObject
            public WhatsAppWhistle whatsAppWhistle = new WhatsAppWhistle();

            public static class WhatsAppWhistle {
                public boolean enabled = false;
                public float volume = 1f;
            }

            public enum SoundReplacement {
                None,
                Blyat,
                Mojaaaang,
                UwU,
                Whatsapp_Whistle
            }
        }
    }
}
