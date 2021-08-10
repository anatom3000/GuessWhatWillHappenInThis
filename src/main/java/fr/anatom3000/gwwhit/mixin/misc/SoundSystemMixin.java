package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static fr.anatom3000.gwwhit.GWWHITClient.MOJAAAANG_SOUND_EVENT;

@Mixin(SoundSystem.class)
public class SoundSystemMixin {
    @Inject(method = "start", at = @At("TAIL"))
    public void onStart(CallbackInfo ci) {
        if (ConfigManager.getLoadedConfig().audio.mojaaaangStartupSound)
            MinecraftClient.getInstance().getSoundManager().play(
                PositionedSoundInstance.master(
                    MOJAAAANG_SOUND_EVENT,
                    1f,
                    1f
                )
            );
    }
}
