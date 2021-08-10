package fr.anatom3000.gwwhit.config.data;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "audio")
public class AudioConfig implements ConfigData {
    AudioConfig(){}

    @ConfigEntry.Gui.Tooltip
    public boolean mojaaaangStartupSound = false;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public SoundReplacement soundReplacement = SoundReplacement.None;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public WhatsAppWhistle whatsAppWhistle = new WhatsAppWhistle();

    public enum SoundReplacement {
        None,
        Blyat,
        Mojaaaang,
        UwU,
        Whatsapp_Whistle
    }

    public static class WhatsAppWhistle {
        public boolean enabled = false;
        public float volume = 1f;
    }
}
