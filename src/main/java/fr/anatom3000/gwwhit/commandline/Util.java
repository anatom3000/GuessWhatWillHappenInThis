package fr.anatom3000.gwwhit.commandline;

import org.jetbrains.annotations.NotNull;

public class Util {
    @SuppressWarnings("SameParameterValue")
    static <T> boolean contains(T[] array, @NotNull T object) {
        if (array == null) return false;
        for (T value : array) {
            if (object.equals(value)) return true;
        }
        return false;
    }
}
