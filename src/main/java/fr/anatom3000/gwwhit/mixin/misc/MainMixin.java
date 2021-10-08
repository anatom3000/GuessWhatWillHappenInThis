package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.util.ConsoleHacker;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({net.minecraft.client.main.Main.class, net.minecraft.server.Main.class})
public class MainMixin {
    @Inject(method = "main", at = @At("HEAD"))
    private static void earlyLoad(String[] args, CallbackInfo ci) {
        ConsoleHacker.hack();
    }
}
