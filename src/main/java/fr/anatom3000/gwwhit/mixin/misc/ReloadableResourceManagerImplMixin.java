package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.util.WrappedPack;
import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.ResourcePack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ReloadableResourceManagerImpl.class)
public class ReloadableResourceManagerImplMixin {
    @ModifyVariable(method = "addPack(Lnet/minecraft/resource/ResourcePack;)V", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private ResourcePack modifyPack(ResourcePack pack) {
        return new WrappedPack(pack);
    }
}
