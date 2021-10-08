package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.GWWHIT;

import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ItalianUtil {
    private static final List<String> NAMES = SafeUtils.doSafely(() -> Files.readAllLines(GWWHIT.ASSETS_ROOT.resolve("italian.txt")));
    private static final Set<String> USED_NAMES = new HashSet<>();
    public static String getRandomWord(Random rng, boolean uppercase) {
        String n = "";
        while (USED_NAMES.contains(n)
                || n.length() < 5
                || n.length() > 15
                || !n.matches("^[a-zA-Z]+$")) {
            assert NAMES != null;
            n = NAMES.get(rng.nextInt(NAMES.size()));
        }
        if (uppercase)
            n = Character.toUpperCase(n.charAt(0)) + n.substring(1);
        USED_NAMES.add(n);
        return n;
    }
}
