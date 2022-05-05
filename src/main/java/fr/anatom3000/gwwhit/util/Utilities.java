package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.commandline.ModUpdater;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Objects;

/**
 * DONT USE ANY MC/MOD/MC-RELATED LIB CLASSES HERE
 * safe to use class outside of mc
 * @author ENDERZOMBI102
 */
public final class Utilities {
    public static InputStream getResource(@NotNull String name) {
        return Utilities.class.getResourceAsStream(name);
    }

    /**
     * Given a resource name/path, returns its URL (includes path to jar file)
     * @param name resource to search
     */
    public static URL getResourceURL(@NotNull String name) {
        return Utilities.class.getResource(name);
    }

    /**
     * Checks if an array contains a value
     * @param array array to check
     * @param object obj to search for
     * @return true if found
     */
    public static <T> boolean contains(T[] array, @NotNull T object) {
        if (array == null)
            return false;
        for (T value : array) {
            if (object.equals(value))
                return true;
        }
        return false;
    }

    /**
     * Returns the location of the GWWHIT jar
     * @return the path of the jar
     */
    public static Path getJarLocation() {
        return Path.of(
            Objects.requireNonNull(
                SafeUtils.doSafely(
                    () -> ModUpdater.class.getProtectionDomain().getCodeSource().getLocation().toURI()
                )
            )
        );
    }

    /**
     * Returns a value between min and max, if the given value is higher or lower, it will be replaced by its bound.
     * @param min Minimum value
     * @param max Maximum value
     * @param value Value to clamp
     * @return Clamped value
     */
    public static int clamp( int min, int max, int value ) {
        return value < min ? 0 : value > max ? 255 : value;
    }

    /**
     * Basically same as clamp, but with the values inverted ( < min = max and >max = min )
     * Returns a value between min and max, if the given value is higher or lower, it will be replaced by its bound.
     * @param min Minimum value
     * @param max Maximum value
     * @param value Value to clamp
     * @return Clamped value
     */
    public static int inverseClamp( int min, int max, int value ) {
        return value < min ? 255 : value > max ? 0 : value;
    }

    public static <T> float getFloatField( T obj, String name ) {
        try {
            var field = obj.getClass().getField(name);
            field.setAccessible( true );
            return field.getFloat( obj );
        } catch (Throwable e) { throw new RuntimeException(e); }
    }
}
