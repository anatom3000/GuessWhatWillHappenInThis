package fr.anatom3000.gwwhit.mixin.worldgen;

import fr.anatom3000.gwwhit.imixin.IFixedYOffset;
import net.minecraft.world.gen.HeightContext;
import net.minecraft.world.gen.YOffset;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net.minecraft.world.gen.YOffset$Fixed"})
public class FixedYOffsetMixin implements IFixedYOffset {
    private Double gwwhit$pos = null;

    @Inject(method = "getY(Lnet/minecraft/world/gen/HeightContext;)I", at = @At("HEAD"), cancellable = true)
    void adjustY(HeightContext context, CallbackInfoReturnable<Integer> res) {
        if (gwwhit$pos != null)
            res.setReturnValue((int) (context.getMinY() + (context.getMaxY() - context.getMinY()) * gwwhit$pos));
    }

    @Override
    public YOffset setPos(double d) {
        gwwhit$pos = d;
        return (YOffset) (Object) this;
    }
}
