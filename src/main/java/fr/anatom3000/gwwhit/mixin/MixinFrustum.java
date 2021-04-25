package fr.anatom3000.gwwhit.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Environment(EnvType.CLIENT)
@Mixin(Frustum.class)
public class MixinFrustum {
    /**
     * @author concern
     */
    @Overwrite
    public boolean isVisible(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return true;
    }
}