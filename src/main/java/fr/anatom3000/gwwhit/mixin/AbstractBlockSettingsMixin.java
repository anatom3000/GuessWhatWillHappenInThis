package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Function;

@Mixin(AbstractBlock.Settings.class)
public class AbstractBlockSettingsMixin {
    @Shadow
    float slipperiness;

    @Inject(method = "<init>(Lnet/minecraft/block/Material;Ljava/util/function/Function;)V", at = @At("TAIL"))
    private void postInit(Material material, Function<BlockState, MapColor> mapColorProvider, CallbackInfo ci) {
        slipperiness = ConfigManager.getLoadedConfig().gameplay.blocks.defaultSlipperiness;
    }
}
