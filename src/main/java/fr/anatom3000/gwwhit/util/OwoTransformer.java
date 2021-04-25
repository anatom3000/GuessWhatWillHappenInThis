package fr.anatom3000.gwwhit.util;

import java.util.function.UnaryOperator;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;

public class OwoTransformer implements UnaryOperator<String> {
    public static final OwoTransformer TRANSFORMER_SIMPLE = new OwoTransformer(false, false);
    public static final OwoTransformer TRANSFORMER_SUFFIX = new OwoTransformer(false, true);
    public static final OwoTransformer TRANSFORMER_PREFIX = new OwoTransformer(true, false);
    public static final OwoTransformer TRANSFORMER_FULL = new OwoTransformer(true, true);

    private static String[] prefixes = new String[] {
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
    private static String[] suffixes = new String[] {
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
    private boolean prefix;
    private boolean suffix;


    @Override
    public String apply(String str) {
        String result = "";
        if (prefix)
            result += prefixes[GuessWhatWillHappenInThisMod.rng.nextInt(prefixes.length)];
        result += substitute(str);
        if (suffix)
            result += suffixes[GuessWhatWillHappenInThisMod.rng.nextInt(suffixes.length)];
        return result;
    }

    private static String substitute(String text) {
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
