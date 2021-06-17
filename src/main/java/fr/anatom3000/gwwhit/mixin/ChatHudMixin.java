package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.config.ModConfig;
import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.sound.PositionedSoundInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static fr.anatom3000.gwwhit.GWWHITClient.WHISTLE_SOUND_EVENT;

@Mixin(ChatHud.class)
public class ChatHudMixin {

    @Inject(at = @At("HEAD"), method = "addMessage(Lnet/minecraft/text/Text;)V")
    private void gwwhit$playWhatsAppWhistleSound(CallbackInfo callbackInfo) {
        ModConfig.Cosmetic.Audio.WhatsAppWhistle whistle = ConfigManager.getLoadedConfig().cosmetic.audio.whatsAppWhistle;
        if (!whistle.enabled) {
            return;
        }
        MinecraftClient.getInstance().getSoundManager().play(
                PositionedSoundInstance.master(WHISTLE_SOUND_EVENT, 1f, whistle.volume)
        );
    }

}
