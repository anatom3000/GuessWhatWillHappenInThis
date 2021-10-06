package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.client.option.Option;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Option.class)
public class OptionMixin {

    @SuppressWarnings("UnresolvedMixinReference") // mcdev doesn't resolve clinit yet
    @ModifyConstant(method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD",
                            target = "Lnet/minecraft/client/option/Option;CHAT_DELAY_INSTANT:Lnet/minecraft/client/option/DoubleOption;",
                            opcode = Opcodes.PUTSTATIC),
                    to = @At(value = "FIELD",
                            target = "Lnet/minecraft/client/option/Option;FOV:Lnet/minecraft/client/option/DoubleOption;",
                            opcode = Opcodes.PUTSTATIC)
            ),
            expect = 2,
            require = 2
    )
    private static double hackFov(double value) {
        if (value == 110D) return ConfigManager.getActiveConfig().misc.fov.max;
        if (value == 30D) return ConfigManager.getActiveConfig().misc.fov.min;

        return value;
    }
}
