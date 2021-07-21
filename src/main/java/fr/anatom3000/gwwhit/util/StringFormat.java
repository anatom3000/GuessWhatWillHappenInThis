package fr.anatom3000.gwwhit.util;

import java.util.Arrays;

public final class StringFormat {
    private StringFormat() {}
    
    public static final String RESET = create(0);
    
    public static final String BOLD = create(1);
    public static final String FAINT = create(2);
    public static final String ITALIC = create(3);
    public static final String UNDERLINE = create(4);
    public static final String BLINK = create(5);
    public static final String OVERLINE = create(22);
    
    public static final String BLACK = create(30);
    public static final String RED = create(31);
    public static final String GREEN = create(32);
    public static final String YELLOW = create(33);
    public static final String BLUE = create(34);
    public static final String MAGENTA = create(35);
    public static final String CYAN = create(36);
    public static final String WHITE = create(37);
    
    public static final String[] EFFECTS = {BOLD, FAINT, ITALIC, UNDERLINE, BLINK, OVERLINE};
    public static final String[] STANDARD_COLORS = {BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, WHITE};
    
    public static String color(int r, int g, int b) {
        return create(38, 2, r, g, b);
    }
    
    private static String create(int code, Object... args) {
        return "\u001B[" + code + ";" + String.join(";", () -> Arrays.stream(args).map(Object::toString).map(string -> (CharSequence) string).iterator()) + "m";
    }
}
