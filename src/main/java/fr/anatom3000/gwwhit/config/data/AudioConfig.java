package fr.anatom3000.gwwhit.config.data;

import fr.anatom3000.gwwhit.config.SyncOptions;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.EnumHandler;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.EnumHandler.EnumDisplayOption;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;

import static fr.anatom3000.gwwhit.config.SyncOptions.*;

@SuppressWarnings("CanBeFinal") // Shut up code inspection
@Config(name = "audio")
public class AudioConfig implements ConfigData {
    AudioConfig(){}

    @SyncOptions(CLIENT) @Tooltip public boolean mojaaaangStartupSound = false;
    @SyncOptions(CLIENT | SYNCED) @Tooltip @EnumHandler(option = EnumDisplayOption.BUTTON) public SoundReplacement soundReplacement = SoundReplacement.None;
    @SyncOptions(GROUP) @Tooltip @CollapsibleObject public WhatsAppWhistle whatsAppWhistle = new WhatsAppWhistle();

    public enum SoundReplacement {
        None,
        Blyat,
        Mojaaaang,
        UwU,
        Whatsapp_Whistle
    }

    public static class WhatsAppWhistle {
        @SyncOptions(CLIENT | SYNCED) public boolean enabled = false;
        @SyncOptions(CLIENT | SYNCED) public float volume = 1f;
    }
}
