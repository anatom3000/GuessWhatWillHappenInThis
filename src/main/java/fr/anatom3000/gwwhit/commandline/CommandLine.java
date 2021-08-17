package fr.anatom3000.gwwhit.commandline;

import fr.anatom3000.gwwhit.util.Utilities;
import org.jetbrains.annotations.NotNull;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLine {
    private static final Scanner IN = new Scanner(new InputStreamReader(System.in));
    private static final HashMap<String, String> COLORS = new HashMap<>() {{
        put("reset", "\u001B[0m");
        put("black", "\u001B[30m");
        put("red", "\u001B[31m");
        put("green", "\u001B[32m");
        put("yellow", "\u001B[33m");
        put("blue", "\u001B[34m");
        put("purple", "\u001B[35m");
        put("cyan", "\u001B[36m");
        put("white", "\u001B[37m");
    }};
    public static boolean debugMode;

    public static void main(String[] args) {
        debugMode = Utilities.contains(args, "--debug");
        try {
            ModUpdater.main(args);
        } catch (Throwable e) {
            CommandLine.println("<clr:red>Something went while loading! Did you use the correct jar?");
            if ( debugMode )
                e.printStackTrace();
        }
    }

    private static String replaceColors(@NotNull String str) {
        boolean appendReset = false;
        for (Map.Entry<String, String> entry : COLORS.entrySet() ) {
            if ( str.contains( "<clr:" + entry.getKey() + ">" ) ) {
                appendReset = true;
                str = str.replaceAll("<clr:" + entry.getKey() + ">", entry.getValue() );
            }
        }
        return appendReset ? str + COLORS.get("reset") : str;
    }

    public static void print(@NotNull String str) {
        System.out.print( replaceColors(str) );
    }

    public static void println(@NotNull String str) {
        System.out.println( replaceColors(str) );
    }

    public static String prompt(@NotNull String message) {
        CommandLine.print(message);
        return IN.nextLine();
    }
}
