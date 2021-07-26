package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Material.Builder.class)
public class MaterialBuilderMixin {
    @Shadow private boolean burnable;
    @Shadow private boolean replaceable;
    
    @Inject(method = "<init>", at = @At("TAIL"))
    private void postInit(MapColor color, CallbackInfo ci) {
        replaceable = ConfigManager.getLoadedConfig().gameplay.blocks.replaceEverything;
    }
}
