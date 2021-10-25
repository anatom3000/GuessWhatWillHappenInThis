package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.util.ResourceUtil;
import net.minecraft.client.gui.screen.TitleScreen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Shadow
    @Nullable
    private String splashText;

    @ModifyConstant(method = "render(Lnet/minecraft/client/util/math/MatrixStack;IIF)V", constant = {@Constant(intValue = 98), @Constant(intValue = 88)})
    public int repositionEdition(int old) {
        int i = old;

        if (old == 98) i += 30;
        if (old == 88) i -= 15;

        return i;
    }

    @Inject(at = @At("RETURN"), method = "init()V")
    public void initPost(CallbackInfo info) {
        if (ConfigManager.getActiveConfig().misc.beemovie.replaceSplashes)
            splashText = ResourceUtil.getBeeMovieRandomLine(true);
    }
}
