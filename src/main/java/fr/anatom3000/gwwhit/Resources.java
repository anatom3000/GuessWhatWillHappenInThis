package fr.anatom3000.gwwhit;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.util.math.MathHelper;

public class Resources {

    public static void makeFieldAccessible(Field field) throws Exception {
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        try {
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.PROTECTED);
            modifiers.setInt(field, field.getModifiers() | Modifier.PUBLIC);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static float getDistanceFromDeltas(double dx, double dy, double dz)
    {
        return MathHelper.sqrt((float) (dx * dx + dy * dy + dz * dz));
    }

    public static float lerp(float a, float b, float lerp)
    {
        return a + lerp * (b - a);
    }
}