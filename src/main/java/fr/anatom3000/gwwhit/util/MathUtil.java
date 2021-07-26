package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.GWWHIT;
import net.minecraft.util.math.MathHelper;

public class MathUtil {
    public static double boxedInvert(double min, double max, double value) {
        return max - value + min;
    }

    public static double boxedInvert(double value) {
        return boxedInvert(MathHelper.floor(value), MathHelper.ceil(value), value);
    }

    public static float boxedInvert(float min, float max, float value) {
        return max - value + min;
    }

    public static float boxedInvert(float value) {
        return boxedInvert(MathHelper.floor(value), MathHelper.ceil(value), value);
    }

    public static boolean getChance(float percent) {
        if (percent <= 0) {
            return false;
        }
        float roll = GWWHIT.RANDOM.nextFloat() * 100;
        return percent >= roll;
    }
}
