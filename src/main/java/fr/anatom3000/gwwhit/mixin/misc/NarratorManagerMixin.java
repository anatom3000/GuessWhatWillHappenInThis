package fr.anatom3000.gwwhit.mixin.misc;

import com.mojang.text2speech.Narrator;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.util.NarratorExt;
import fr.anatom3000.gwwhit.util.ResourceUtil;
import net.minecraft.client.util.NarratorManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(NarratorManager.class)
public class NarratorManagerMixin implements NarratorExt {
    @Shadow
    @Final
    private Narrator narrator;

    @Override
    public void gwwhit$load() {
        if (ConfigManager.getActiveConfig().misc.beemovie.playNarrator) {
            narrator.clear();
            for (String paragraph : ResourceUtil.getBeeMovieParagraphs(false)) {
                narrator.say(paragraph, false);
            }
        }
    }
}
