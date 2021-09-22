package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FallingBlock.class)
public class FallingBlockMixin {
    @Redirect(method = "canFallThrough", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Material;isReplaceable()Z"))
    private static boolean fixSand(Material material) {
        if (ConfigManager.getActiveConfig().gameplay.blocks.replaceEverything) return false;
        return material.isReplaceable();
    }
}
