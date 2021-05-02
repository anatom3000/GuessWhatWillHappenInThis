package fr.anatom3000.gwwhit.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @ModifyConstant(method = "render(Lnet/minecraft/client/util/math/MatrixStack;IIF)V")
    public int repositionEdition(int old) {
        int i = old;
        
        if (old == 98) i += 30;
        if (old == 88) i -= 15;
        
        return i;
    }
}
