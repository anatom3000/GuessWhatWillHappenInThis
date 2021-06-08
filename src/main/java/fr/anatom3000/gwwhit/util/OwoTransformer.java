package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.ConfigLoader;

import java.util.function.UnaryOperator;

public class OwoTransformer implements UnaryOperator<String> {
    public static final OwoTransformer TRANSFORMER_SIMPLE = new OwoTransformer(false, false);
    public static final OwoTransformer TRANSFORMER_SUFFIX = new OwoTransformer(false, true);
    public static final OwoTransformer TRANSFORMER_PREFIX = new OwoTransformer(true, false);
    public static final OwoTransformer TRANSFORMER_FULL = new OwoTransformer(true, true);

    private static final String[] prefixes = new String[] {
            "<3 ",
            "0w0 ",
            "H-hewwo?? ",
            "HIIII! ",
            "Haiiii! ",
            "Huohhhh. ",
            "OWO ",
            "OwO ",
            "UwU "
    };
    private static final String[] suffixes = new String[] {
            " ( ͡° ᴥ ͡°)",
            " (இωஇ )",
            " (๑•́ ₃ •̀๑)",
            " (• o •)",
            " (●´ω｀●)",
            " (◠‿◠✿)",
            " (✿ ♡‿♡)",
            " (　\"◟ \")",
            " (人◕ω◕)",
            " (；ω；)",
            " (｀へ´)",
            " ._.",
            " :3",
            " :D",
            " :P",
            " ;-;",
            " ;3",
            " ;_;",
            " >_<",
            " >_>",
            " UwU",
            " XDDD",
            " ^-^",
            " ^_^",
            " x3",
            " x3",
            " xD",
            " ÙωÙ",
            " ʕʘ‿ʘʔ",
            " ʕ•̫͡•ʔ",
            " ㅇㅅㅇ",
            ", fwendo",
            "（＾ｖ＾）"
    };
    private final boolean prefix;
    private final boolean suffix;


    @Override
    public String apply(String str) {
        if (!ConfigLoader.getLoadedConfig().cosmetic.owoifyer || str == null) {
            return str;
        }
        String result = "";
        if (prefix) {
            result += prefixes[GWWHIT.RANDOM.nextInt(prefixes.length)];
        }
        result += substitute(str);
        if (suffix) {
            result += suffixes[GWWHIT.RANDOM.nextInt(suffixes.length)];
        }
        return result;
    }

    private static String substitute(String text) {
        if (text == null) {
            return null;
        }
        return text
                .replaceAll("r", "w")
                .replaceAll("l", "w")
                .replaceAll("R", "W")
                .replaceAll("L", "W")
                .replaceAll("no", "nu")
                .replaceAll("has", "haz")
                .replaceAll("have", "haz")
                .replaceAll("you", "uu")
                .replaceAll("the ", "da ")
                .replaceAll("The ", "Da ");
    }

    private OwoTransformer(boolean prefix, boolean suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }
}
