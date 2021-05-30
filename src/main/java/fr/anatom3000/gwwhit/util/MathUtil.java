package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import net.minecraft.util.math.MathHelper;

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

    public static boolean getChance(float percent) {
        if (percent <= 0) {
            return false;
        }
        float roll = GuessWhatWillHappenInThisMod.RANDOM.nextFloat() * 100;
        return percent >= roll;
    }

}
