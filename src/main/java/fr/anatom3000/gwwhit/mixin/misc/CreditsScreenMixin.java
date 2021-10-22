package fr.anatom3000.gwwhit.mixin.misc;

import com.google.common.collect.Lists;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.util.ResourceUtil;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import net.minecraft.client.gui.screen.CreditsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(CreditsScreen.class)
public class CreditsScreenMixin extends Screen {
    @Mutable
    @Shadow
    @Final
    private boolean endCredits;

    @Shadow
    private List<OrderedText> credits;

    @Shadow
    private IntSet centeredLines;

    @Shadow
    private int creditsHeight;

    protected CreditsScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "<init>(ZLjava/lang/Runnable;)V")
    public void instantiate(boolean endCredits, Runnable finishAction, CallbackInfo info) {
        if (ConfigManager.getActiveConfig().misc.beemovie.replaceCredits)
            this.endCredits = true;
    }

    @Inject(at = @At("RETURN"), method = "init()V")
    public void init(CallbackInfo info) {
        if (ConfigManager.getActiveConfig().misc.beemovie.replaceCredits) {
            this.credits = Lists.newArrayList();
            this.centeredLines = new IntOpenHashSet();
            for (String paragraph : ResourceUtil.getBeeMovieParagraphs(true))
                credits.addAll(client.textRenderer.wrapLines(new LiteralText(paragraph), 274));
            this.creditsHeight = this.credits.size() * 12;
        }
    }
}
