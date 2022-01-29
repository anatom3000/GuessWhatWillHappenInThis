package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.config.data.MoreOresConfig;

import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class NameGenerator {
    private static final Set<String> alreadyGenerated = new HashSet<>();
    private static final String[] vowels = new String[]{"e", "a", "u", "o", "i", "io", "oi", "ou", "ee", "oo", "ia", "ea", "ao"};
    private static final String[] consonants = new String[]{"st", "c", "cw", "tr", "f", "fr", "p", "g", "qu", "s", "bw", "h", "n"};
    private static final String[] endings = new String[]{"ite", "ium"};
    public static String generateOreName(Random rng) {
        MoreOresConfig mo = ConfigManager.getActiveConfig().moreOres;
        int length = rng.nextInt(mo.oreNameLengthMax - mo.oreNameLengthMin + 1) + mo.oreNameLengthMin;
        StringBuilder name = new StringBuilder();
        boolean isConsonant = length % 2 == 1;
        for (int i = 0; i < length; i++) {
            isConsonant = !isConsonant;
            String[] source = (i == length - 1 && rng.nextBoolean()) ? endings : (isConsonant ? consonants : vowels);
            name.append(source[rng.nextInt(source.length)]);
        }
        String resultName = name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1);
        if (alreadyGenerated.contains(resultName)) {
            return generateOreName(rng);
        }
        else {
            alreadyGenerated.add(resultName);
            return resultName;
        }
    }
}
