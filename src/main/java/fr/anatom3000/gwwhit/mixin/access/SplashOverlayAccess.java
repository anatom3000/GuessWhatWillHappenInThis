package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.resource.ResourceReload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Optional;
import java.util.function.Consumer;

@Mixin(SplashOverlay.class)
public interface SplashOverlayAccess {
    @Accessor
    ResourceReload getReload();

    @Accessor
    Consumer<Optional<Throwable>> getExceptionHandler();

    @Accessor
    boolean getReloading();
}
