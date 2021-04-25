package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.WrappedPack;
import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.ResourcePack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ReloadableResourceManagerImpl.class)
public class ReloadableResourceManagerImplMixin {
    @ModifyArg(method = "beginMonitoredReload(L;L;L;L;)Lnet/minecraft/resource/ResourceReloadMonitor;", at = @At(value = "INVOKE", target = "Lnet/minecraft/resource/ReloadableResourceManagerImpl;addPack(Lnet/minecraft/resource/ResourcePack;)V"), index = 0)
    private ResourcePack modifyPack(ResourcePack pack) {
        return new WrappedPack(pack);
    }
}