package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MathHelper.class)
public class MathHelperMixin {

    @Shadow
    @Final
    private static float[] SINE_TABLE;

    @Inject( method = "cos", at = @At( "HEAD" ), cancellable = true )
    private static void onCosRequest( float value, CallbackInfoReturnable<Float> cir ) {
        if ( ConfigManager.getActiveConfig().misc.invertCoSin )
            cir.setReturnValue( SINE_TABLE[ (int) ( value * 10430.378F ) & 65535 ] );
    }

    @Inject( method = "sin", at = @At( "HEAD" ), cancellable = true )
    private static void onSinRequest( float value, CallbackInfoReturnable<Float> cir ) {
        if ( ConfigManager.getActiveConfig().misc.invertCoSin )
            cir.setReturnValue( SINE_TABLE[ (int) ( value * 10430.378F + 16384.0F ) & 65535 ] );
    }

}
