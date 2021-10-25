package fr.anatom3000.gwwhit.option;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.DoubleOption;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.DoubleSupplier;
import java.util.function.Function;

public class DynamicSizeDoubleOption extends DoubleOption {
    private final DoubleSupplier minGetter;
    private final DoubleSupplier maxGetter;

    public DynamicSizeDoubleOption(String key, DoubleSupplier minGetter, DoubleSupplier maxGetter, float step, Function<GameOptions, Double> getter, BiConsumer<GameOptions, Double> setter, BiFunction<GameOptions, DoubleOption, Text> displayStringGetter, Function<MinecraftClient, List<OrderedText>> tooltipsGetter) {
        super(key, minGetter.getAsDouble(), maxGetter.getAsDouble(), step, getter, setter, displayStringGetter, tooltipsGetter);
        this.minGetter = minGetter;
        this.maxGetter = maxGetter;
    }

    public DynamicSizeDoubleOption(String key, DoubleSupplier minGetter, DoubleSupplier maxGetter, float step, Function<GameOptions, Double> getter, BiConsumer<GameOptions, Double> setter, BiFunction<GameOptions, DoubleOption, Text> displayStringGetter) {
        this(key, minGetter, maxGetter, step, getter, setter, displayStringGetter, client -> Collections.emptyList());
    }

    @Override
    public double getRatio(double value) {
        return MathHelper.clamp((this.adjust(value) - getMin()) / (getMax() - getMin()), 0.0D, 1.0D);
    }

    @Override
    public double getValue(double ratio) {
        return this.adjust(MathHelper.lerp(MathHelper.clamp(ratio, 0.0D, 1.0D), getMin(), getMax()));
    }

    @Override
    public double getMin() {
        return minGetter.getAsDouble();
    }

    @Override
    public double getMax() {
        return maxGetter.getAsDouble();
    }

    private double adjust(double value) {
        if (this.step > 0.0F) {
            value = this.step * (float)Math.round(value / (double)this.step);
        }

        return MathHelper.clamp(value, getMin(), getMax());
    }
}
