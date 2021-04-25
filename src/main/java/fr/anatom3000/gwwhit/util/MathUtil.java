package fr.anatom3000.gwwhit.util;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;

public class MathUtil {
    public static double BoxedInvert(double min, double max, double value) {
        return max - value + min;
    }

    public static double BoxedInvert(double value) {
        return BoxedInvert(MathHelper.floor(value), MathHelper.ceil(value), value);
    }

    public static float BoxedInvert(float min, float max, float value) {
        return max - value + min;
    }

    public static float BoxedInvert(float value) {
        return BoxedInvert(MathHelper.floor(value), MathHelper.ceil(value), value);
    }
}
