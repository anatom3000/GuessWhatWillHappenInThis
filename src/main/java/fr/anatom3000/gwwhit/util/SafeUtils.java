package fr.anatom3000.gwwhit.util;

/**
 * Utility methods for calling methods without having to deal with exceptions.
 * @author MattiDragon
 */
public class SafeUtils {

    /**
     * Call the runnable and ignores any exceptions it throws. Does not ignore errors.
     * @param runnable The runnable to run.
     */
    public static void doSafely(ThrowingRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception ignored) {
        }
    }

    /**
     * Uses the supplier to get a value and returns it. If it throws an exception {@code null} will be returned. Does not account for errors.
     * @param supplier The supplier to use.
     */
    public static <T> T doSafely(ThrowingSupplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception ignored) {
            return null;
        }
    }

    @FunctionalInterface
    public interface ThrowingRunnable {
        void run() throws Exception;
    }

    @FunctionalInterface
    public interface ThrowingSupplier<T> {
        T get() throws Exception;
    }
}
