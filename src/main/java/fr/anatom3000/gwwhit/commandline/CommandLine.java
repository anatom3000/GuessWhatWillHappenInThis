package fr.anatom3000.gwwhit.commandline;

import org.jetbrains.annotations.NotNull;

public class CommandLine {
    public static void main(String[] args) {
        try {
            ModUpdater.main(args);
        } catch (Throwable e) {
            System.out.println("Something went while loading! Did you use the correct jar?");
            if (contains(args, "--debug")) e.printStackTrace();
        }
    }

    public static <T> boolean contains(T[] array, @NotNull T object) {
        if (array == null) return false;
        for (T value : array) {
            if (object.equals(value)) return true;
        }
        return false;
    }
}
