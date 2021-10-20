package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.block.Block;
import org.lwjgl.system.CallbackI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "getSlipperiness", at = @At("TAIL"), cancellable = true)
    private void overrideSlipperiness(CallbackInfoReturnable<Float> cir) {
        if (cir.getReturnValueF() == 0.6F) {
            cir.setReturnValue(ConfigManager.getActiveConfig().gameplay.blocks.defaultSlipperiness);
            cir.cancel();
        }
    }
}
