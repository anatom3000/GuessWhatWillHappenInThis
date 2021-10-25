package fr.anatom3000.gwwhit.mixin.misc;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.option.DynamicSizeDoubleOption;
import net.minecraft.client.option.DoubleOption;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Option;
import net.minecraft.text.Text;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Mixin(Option.class)
public class OptionMixin {

    @SuppressWarnings("UnresolvedMixinReference") // mcdev doesn't resolve clinit yet
    @Redirect(method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "(Ljava/lang/String;DDFLjava/util/function/Function;Ljava/util/function/BiConsumer;Ljava/util/function/BiFunction;)Lnet/minecraft/client/option/DoubleOption;"),
            slice = @Slice(
                    from = @At(value = "FIELD",
                            target = "Lnet/minecraft/client/option/Option;CHAT_DELAY_INSTANT:Lnet/minecraft/client/option/DoubleOption;",
                            opcode = Opcodes.PUTSTATIC),
                    to = @At(value = "FIELD",
                            target = "Lnet/minecraft/client/option/Option;FOV:Lnet/minecraft/client/option/DoubleOption;",
                            opcode = Opcodes.PUTSTATIC)
            )
    )
    private static DoubleOption changeFOV(String key, double min, double max, float step, Function<GameOptions, Double> getter, BiConsumer<GameOptions, Double> setter, BiFunction<GameOptions, DoubleOption, Text> displayStringGetter) {
        return new DynamicSizeDoubleOption(key,
                () -> ConfigManager.getActiveConfig().misc.fov.min,
                () -> ConfigManager.getActiveConfig().misc.fov.max,
                step,
                getter,
                setter,
                displayStringGetter);
    }
}
