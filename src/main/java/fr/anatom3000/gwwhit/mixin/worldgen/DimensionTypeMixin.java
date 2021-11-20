package fr.anatom3000.gwwhit.mixin.worldgen;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.mixin.access.DimensionTypeAccess;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DimensionType.class)
public class DimensionTypeMixin {
    @Shadow
    @Final
    protected static DimensionType OVERWORLD;

    @Inject(at = @At("TAIL"), method = "<clinit>")
    private static void tweakOverworld(CallbackInfo ci) {
        if (ConfigManager.getActiveConfig().misc.increaseWorldHeight) {
            ((DimensionTypeAccess) OVERWORLD).setMinimumY(-256);
        }
    }
}
