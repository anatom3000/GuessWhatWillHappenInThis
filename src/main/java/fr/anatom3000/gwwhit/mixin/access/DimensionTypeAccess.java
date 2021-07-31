package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DimensionType.class)
public interface DimensionTypeAccess {
    @Accessor
    void setMinimumY(int newVal);
}
