package fr.anatom3000.gwwhit.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.materials.CustomOre;
import fr.anatom3000.gwwhit.materials.CustomOre.Dimension;
import fr.anatom3000.gwwhit.materials.CustomOre.Type;
import net.devtech.arrp.json.lang.JLang;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

@SuppressWarnings("SpellCheckingInspection") //Because custom names
public class NewMaterials {

    public static final List<CustomOre> ores = new ArrayList<>() {{
        add(new CustomOre("Amader", Type.INGOT, true, true, false, Dimension.NETHER, DyeColor.LIME));
        add(new CustomOre("Anaksox", Type.INGOT, true, true, false, Dimension.NETHER, DyeColor.GREEN));
        add(new CustomOre("Aqyqyf", Type.INGOT, false, true, false, Dimension.END, DyeColor.PINK));
        add(new CustomOre("Asymcof", Type.INGOT, false, true, false, Dimension.NETHER, DyeColor.PURPLE));
        add(new CustomOre("Baqi", Type.DUST, false, true, false, Dimension.OVERWORLD, DyeColor.RED));
        add(new CustomOre("Botud", Type.GEM, false, true, false, Dimension.OVERWORLD, DyeColor.PURPLE));
        add(new CustomOre("Cojos", Type.GEM, false, true, true, Dimension.END, DyeColor.ORANGE));
        add(new CustomOre("Dytap", Type.GEM, false, true, false, Dimension.NETHER, DyeColor.PURPLE));
        add(new CustomOre("Ebeqir", Type.GEM, false, true, true, Dimension.END, DyeColor.BROWN));
        add(new CustomOre("Ecywygs", Type.GEM, false, true, true, Dimension.OVERWORLD, DyeColor.BROWN));
        add(new CustomOre("Emilamd", Type.INGOT, false, false, true, Dimension.OVERWORLD, DyeColor.BLUE));
        add(new CustomOre("Emogy", Type.INGOT, true, false, true, Dimension.NETHER, DyeColor.GREEN));
        add(new CustomOre("Emussazr", Type.INGOT, true, true, true, Dimension.END, DyeColor.MAGENTA));
        add(new CustomOre("Exuzi", Type.INGOT, true, false, true, Dimension.NETHER, DyeColor.CYAN));
        add(new CustomOre("Folso", Type.DUST, false, true, true, Dimension.OVERWORLD, DyeColor.LIME));
        add(new CustomOre("Foqepm", Type.GEM, false, true, true, Dimension.NETHER, DyeColor.ORANGE));
        add(new CustomOre("Fucox", Type.DUST, false, true, false, Dimension.END, DyeColor.BLUE));
        add(new CustomOre("Fydif", Type.GEM, false, true, false, Dimension.NETHER, DyeColor.RED));
        add(new CustomOre("Fyfat", Type.GEM, false, true, false, Dimension.END, DyeColor.MAGENTA));
        add(new CustomOre("Garar", Type.DUST, false, true, true, Dimension.NETHER, DyeColor.BLUE));
        add(new CustomOre("Gigyh", Type.GEM, true, false, true, Dimension.END, DyeColor.MAGENTA));
        add(new CustomOre("Giry", Type.DUST, true, false, true, Dimension.END, DyeColor.GREEN));
        add(new CustomOre("Gycu", Type.GEM, true, false, true, Dimension.NETHER, DyeColor.ORANGE));
        add(new CustomOre("Hoke", Type.DUST, false, false, true, Dimension.END, DyeColor.BLUE));
        add(new CustomOre("Hugom", Type.DUST, false, false, true, Dimension.OVERWORLD, DyeColor.PINK));
        add(new CustomOre("Icawlu", Type.INGOT, true, true, false, Dimension.END, DyeColor.BLUE));
        add(new CustomOre("Igekez", Type.INGOT, true, false, true, Dimension.OVERWORLD, DyeColor.GREEN));
        add(new CustomOre("Ijyqbag", Type.INGOT, true, false, true, Dimension.NETHER, DyeColor.CYAN));
        add(new CustomOre("Ikaqajc", Type.GEM, true, false, true, Dimension.END, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Ipacyk", Type.INGOT, true, false, false, Dimension.NETHER, DyeColor.CYAN));
        add(new CustomOre("Iqecoln", Type.INGOT, true, false, true, Dimension.OVERWORLD, DyeColor.BLUE));
        add(new CustomOre("Iqola", Type.INGOT, true, false, false, Dimension.OVERWORLD, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Izymam", Type.INGOT, true, true, false, Dimension.END, DyeColor.PINK));
        add(new CustomOre("Jipna", Type.DUST, true, false, true, Dimension.END, DyeColor.LIME));
        add(new CustomOre("Kigys", Type.GEM, true, true, true, Dimension.NETHER, DyeColor.RED));
        add(new CustomOre("Kuqoc", Type.DUST, false, false, true, Dimension.OVERWORLD, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Kuzidb", Type.DUST, true, false, true, Dimension.OVERWORLD, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Lezdor", Type.DUST, true, false, true, Dimension.OVERWORLD, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Lisluq", Type.GEM, true, true, false, Dimension.NETHER, DyeColor.PINK));
        add(new CustomOre("Loded", Type.GEM, true, true, false, Dimension.END, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Lotih", Type.GEM, false, false, false, Dimension.END, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Luqysk", Type.GEM, true, false, true, Dimension.END, DyeColor.PINK));
        add(new CustomOre("Lysum", Type.GEM, true, true, false, Dimension.END, DyeColor.MAGENTA));
        add(new CustomOre("Lywyg", Type.GEM, false, false, false, Dimension.NETHER, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Mafab", Type.GEM, true, true, false, Dimension.NETHER, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Mejesh", Type.GEM, true, false, true, Dimension.END, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Mudatb", Type.GEM, false, true, false, Dimension.NETHER, DyeColor.MAGENTA));
        add(new CustomOre("Nafxa", Type.DUST, true, true, false, Dimension.OVERWORLD, DyeColor.RED));
        add(new CustomOre("Nefyf", Type.GEM, true, false, true, Dimension.NETHER, DyeColor.YELLOW));
        add(new CustomOre("Nejun", Type.INGOT, true, false, true, Dimension.OVERWORLD, DyeColor.GREEN));
        add(new CustomOre("Neqaw", Type.GEM, true, false, true, Dimension.NETHER, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Nizuzc", Type.DUST, true, false, false, Dimension.END, DyeColor.LIME));
        add(new CustomOre("Notic", Type.DUST, true, false, false, Dimension.NETHER, DyeColor.PURPLE));
        add(new CustomOre("Nugo", Type.DUST, true, false, false, Dimension.NETHER, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Obaseh", Type.INGOT, false, true, false, Dimension.OVERWORLD, DyeColor.PURPLE));
        add(new CustomOre("Obohylp", Type.INGOT, false, false, true, Dimension.OVERWORLD, DyeColor.BLUE));
        add(new CustomOre("Obuxan", Type.INGOT, true, true, false, Dimension.NETHER, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Ohyxfu", Type.INGOT, false, false, true, Dimension.NETHER, DyeColor.GREEN));
        add(new CustomOre("Opomfam", Type.INGOT, false, false, false, Dimension.END, DyeColor.GREEN));
        add(new CustomOre("Oquge", Type.INGOT, true, false, false, Dimension.END, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Otakag", Type.INGOT, false, false, false, Dimension.NETHER, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Pecced", Type.DUST, true, false, true, Dimension.NETHER, DyeColor.BROWN));
        add(new CustomOre("Peqy", Type.GEM, true, false, true, Dimension.NETHER, DyeColor.MAGENTA));
        add(new CustomOre("Ratfyf", Type.DUST, true, true, false, Dimension.OVERWORLD, DyeColor.YELLOW));
        add(new CustomOre("Renu", Type.GEM, false, true, true, Dimension.NETHER, DyeColor.PURPLE));
        add(new CustomOre("Rydyrp", Type.GEM, false, false, false, Dimension.OVERWORLD, DyeColor.YELLOW));
        add(new CustomOre("Ryqo", Type.DUST, true, false, false, Dimension.NETHER, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Senuz", Type.DUST, false, false, true, Dimension.END, DyeColor.MAGENTA));
        add(new CustomOre("Sijtyw", Type.GEM, true, true, false, Dimension.OVERWORLD, DyeColor.YELLOW));
        add(new CustomOre("Silo", Type.GEM, true, false, false, Dimension.NETHER, DyeColor.YELLOW));
        add(new CustomOre("Soneg", Type.DUST, false, false, true, Dimension.OVERWORLD, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Sushehn", Type.GEM, false, false, false, Dimension.NETHER, DyeColor.YELLOW));
        add(new CustomOre("Suwow", Type.DUST, false, false, false, Dimension.OVERWORLD, DyeColor.WHITE));
        add(new CustomOre("Tefa", Type.DUST, false, false, true, Dimension.OVERWORLD, DyeColor.LIME));
        add(new CustomOre("Tesxes", Type.GEM, false, false, false, Dimension.END, DyeColor.WHITE));
        add(new CustomOre("Tetus", Type.GEM, false, false, true, Dimension.END, DyeColor.LIME));
        add(new CustomOre("Tidziq", Type.GEM, true, false, true, Dimension.NETHER, DyeColor.ORANGE));
        add(new CustomOre("Tifut", Type.INGOT, true, false, false, Dimension.OVERWORLD, DyeColor.CYAN));
        add(new CustomOre("Tugo", Type.GEM, false, true, false, Dimension.END, DyeColor.PURPLE));
        add(new CustomOre("Tushih", Type.DUST, false, false, true, Dimension.OVERWORLD, DyeColor.GREEN));
        add(new CustomOre("Uberteg", Type.INGOT, false, true, false, Dimension.NETHER, DyeColor.PURPLE));
        add(new CustomOre("Uhyqol", Type.INGOT, false, false, true, Dimension.OVERWORLD, DyeColor.BROWN));
        add(new CustomOre("Umaboz", Type.INGOT, true, true, false, Dimension.OVERWORLD, DyeColor.GREEN));
        add(new CustomOre("Uruwogq", Type.INGOT, true, false, false, Dimension.OVERWORLD, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Uwalusq", Type.INGOT, false, true, false, Dimension.END, DyeColor.BLUE));
        add(new CustomOre("Uwaplok", Type.GEM, false, false, false, Dimension.OVERWORLD, DyeColor.RED));
        add(new CustomOre("Uwygan", Type.INGOT, false, false, false, Dimension.NETHER, DyeColor.CYAN));
        add(new CustomOre("Uxurup", Type.INGOT, false, false, false, Dimension.OVERWORLD, DyeColor.LIGHT_BLUE));
        add(new CustomOre("Wekmal", Type.DUST, false, true, true, Dimension.OVERWORLD, DyeColor.PURPLE));
        add(new CustomOre("Wemhec", Type.GEM, false, true, true, Dimension.NETHER, DyeColor.ORANGE));
        add(new CustomOre("Wuhitd", Type.DUST, false, false, false, Dimension.END, DyeColor.GREEN));
        add(new CustomOre("Xugaw", Type.GEM, false, false, false, Dimension.OVERWORLD, DyeColor.YELLOW));
        add(new CustomOre("Yfikal", Type.INGOT, false, true, false, Dimension.NETHER, DyeColor.BLUE));
        add(new CustomOre("Yjosok", Type.INGOT, false, false, true, Dimension.OVERWORLD, DyeColor.GREEN));
        add(new CustomOre("Yjotceh", Type.INGOT, false, false, true, Dimension.NETHER, DyeColor.LIME));
        add(new CustomOre("Yqubef", Type.GEM, false, false, true, Dimension.OVERWORLD, DyeColor.LIGHT_GRAY));
        add(new CustomOre("Ywosduk", Type.INGOT, false, false, false, Dimension.NETHER, DyeColor.LIME));
        add(new CustomOre("Zawuf", Type.GEM, false, true, false, Dimension.END, DyeColor.PINK));
        add(new CustomOre("Zytu", Type.DUST, false, false, false, Dimension.OVERWORLD, DyeColor.YELLOW));
        add(new CustomOre("Zytutb", Type.DUST, false, false, false, Dimension.END, DyeColor.RED));
    }};

    public static void onInitialize() {
        OreInitParam param = new OreInitParam();
        for (String s : GWWHIT.TRANSLATIONS.keySet()) {
            param.lang.put(s, JLang.lang());
        }

        for (CustomOre ore : ores) {
            try {
                ore.onInitialize(param);
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }

        GWWHIT.RESOURCE_PACK.addTag(BlockTags.BEACON_BASE_BLOCKS.getId(), param.blocks);
        GWWHIT.RESOURCE_PACK.addTag(new Identifier("fabric", "items/axes"), param.axes);
        GWWHIT.RESOURCE_PACK.addTag(new Identifier("fabric", "items/hoes"), param.hoes);
        GWWHIT.RESOURCE_PACK.addTag(new Identifier("fabric", "items/pickaxes"), param.pickaxes);
        GWWHIT.RESOURCE_PACK.addTag(new Identifier("fabric", "items/shovels"), param.shovels);
        GWWHIT.RESOURCE_PACK.addTag(new Identifier("fabric", "items/swords"), param.swords);
        for (Map.Entry<String, JLang> entry : param.lang.entrySet()) {
            GWWHIT.RESOURCE_PACK.addLang(GWWHIT.getId(entry.getKey()), entry.getValue());
        }
    }

    public static class OreInitParam {
        public final JTag blocks = JTag.tag();
        public final JTag axes = JTag.tag();
        public final JTag hoes = JTag.tag();
        public final JTag pickaxes = JTag.tag();
        public final JTag shovels = JTag.tag();
        public final JTag swords = JTag.tag();
        public final Map<String, JLang> lang = new HashMap<>();
    }

    public static void onInitializeClient() {
        for (CustomOre ore : ores) {
            try {
                ore.onInitializeClient();
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }
    }
}