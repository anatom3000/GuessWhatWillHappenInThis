package fr.anatom3000.gwwhit;

import com.mojang.text2speech.Narrator;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.mixin.access.NarratorManagerAccess;
import fr.anatom3000.gwwhit.util.ResourceUtil;
import net.minecraft.client.util.NarratorManager;

public class NarratorUtil {
    public static void initialize() {
        Narrator narrator = ((NarratorManagerAccess)NarratorManager.INSTANCE).getNarrator();
        if (ConfigManager.getActiveConfig().misc.beemovie.playNarrator) {
            narrator.clear();
            for (String paragraph : ResourceUtil.getBeeMovieParagraphs(false)) {
                narrator.say(paragraph, false);
            }
        }
    }
}
