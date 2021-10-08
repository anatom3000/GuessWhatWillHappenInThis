package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.GWWHIT;

import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ItalianUtil {
    private static final List<String> names = SafeUtils.doSafely(() -> Files.readAllLines(GWWHIT.ASSETS_ROOT.resolve("italian.txt")));
    private static final Set<String> usedNames = new HashSet<>();
    public static String getRandomWord(Random rng, boolean uppercase) {
        String n = "";
        while (usedNames.contains(n)
                || n.length() < 5
                || n.length() > 15
                || !n.matches("^[a-zA-Z]+$")
                || (uppercase && !Character.isUpperCase(n.charAt(0)))) {
            assert names != null;
            n = names.get(rng.nextInt(names.size()));
        }
        usedNames.add(n);
        return n;
    }
}
