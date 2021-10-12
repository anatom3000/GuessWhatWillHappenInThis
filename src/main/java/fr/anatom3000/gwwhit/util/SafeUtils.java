package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.GWWHIT;

/**
 * Utility methods for calling methods without having to deal with exceptions.
 * @author MattiDragon
 */
public class SafeUtils {
    /**
     * Call the runnable and ignores any exceptions it throws. Exceptions will be printed.
     * @param runnable The runnable to run.
     */
    public static void doSafely(ThrowingRunnable<?> runnable) {
        try {
            runnable.run();
        } catch (Throwable e) {
            GWWHIT.LOGGER.error("Could not execute safely", e);
        }
    }

    /**
     * Uses the supplier to get a value and returns it. If it throws an exception {@code null} will be returned. Exceptions will be printed.
     * @param supplier The supplier to use.
     */
    public static <T> T doSafely(ThrowingSupplier<T, ?> supplier) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            GWWHIT.LOGGER.error("Could not execute safely", e);
            return null;
        }
    }

    public interface ThrowingRunnable<TEx extends Throwable> {
        void run() throws TEx;
    }

    public interface ThrowingSupplier<T, TEx extends Throwable> {
        T get() throws TEx;
    }
}
