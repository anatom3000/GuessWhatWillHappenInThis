package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.imixin.IDimensionType;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DimensionType.class)
public class DimensionTypeMixin implements IDimensionType {
    @Shadow
    @Final
    protected static DimensionType OVERWORLD;

    @Mutable
    @Shadow
    @Final
    private int minimumY;

    @Inject(at = @At("TAIL"), method = "<clinit>")
    private static void tweakOverworld(CallbackInfo ci) {
        if (ConfigManager.getLoadedConfig().content.increaseWorldHeight) {
            ((IDimensionType) OVERWORLD).gwwhit$adjustMinimumY(-256);
        }
    }

    @Override
    public void gwwhit$adjustMinimumY(int newVal) {
        minimumY = newVal;
    }
}
