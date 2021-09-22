package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
@Environment(EnvType.CLIENT)
public class MinecraftClientMixin {
    @Shadow
    private int itemUseCooldown;

    @Inject(method = "doItemUse", at = @At("RETURN"))
    public void doItemUse(CallbackInfo ci) {
        if (ConfigManager.getActiveConfig().gameplay.items.noHardcodedItemCooldown) {
            itemUseCooldown = 0;
        }
    }
}
