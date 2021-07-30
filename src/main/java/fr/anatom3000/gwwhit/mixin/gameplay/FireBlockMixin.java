package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireBlock.class)
public class FireBlockMixin {
    @Inject(method = "getSpreadChance", at = @At("HEAD"), cancellable = true)
    private void changeSpreadChance(BlockState state, CallbackInfoReturnable<Integer> cir) {
        if (state.isAir()) {
            cir.setReturnValue(0);
            cir.cancel();
            return;
        }
        if (ConfigManager.getLoadedConfig().gameplay.blocks.everythingBurns) cir.setReturnValue(50);
        cir.cancel();
    }

    @Inject(method = "getBurnChance(Lnet/minecraft/block/BlockState;)I", at = @At("HEAD"), cancellable = true)
    private void changeBurnChance(BlockState state, CallbackInfoReturnable<Integer> cir) {
        if (state.isAir()) {
            cir.setReturnValue(0);
            cir.cancel();
            return;
        }
        if (ConfigManager.getLoadedConfig().gameplay.blocks.everythingBurns) cir.setReturnValue(30);
    }
}
