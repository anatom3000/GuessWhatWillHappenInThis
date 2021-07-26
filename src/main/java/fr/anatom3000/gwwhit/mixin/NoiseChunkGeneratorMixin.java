package fr.anatom3000.gwwhit.mixin;

import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseChunkGenerator.class)
public class NoiseChunkGeneratorMixin {
    @Inject(at = @At("HEAD"), method = "getHeight", cancellable = true)
    public void getHeight(int x, int z, Type heightmap, HeightLimitView world, CallbackInfoReturnable<Integer> info) {
//        int h = info.getReturnValue();
//        info.setReturnValue(0);
//        double distance = Math.sqrt(x * x + z * z);
//        if (distance > 2500) {
//            h -= 80;
//        }
//        else {
//            if (distance > 2400) {
//                double h_mod = (distance - 2400) / 100.0f;
//                h += 20 - h_mod * 100;
//            } else {
//                h += 20;
//            }
//        }
        info.setReturnValue(0);
    }
}
