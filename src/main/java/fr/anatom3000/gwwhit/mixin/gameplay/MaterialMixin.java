package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.block.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Material.class)
public class MaterialMixin {
    @Inject(method = "isReplaceable", at = @At("TAIL"), cancellable = true)
    private void postInit(CallbackInfoReturnable<Boolean> cir) {
        if (ConfigManager.getActiveConfig().gameplay.blocks.replaceEverything) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
