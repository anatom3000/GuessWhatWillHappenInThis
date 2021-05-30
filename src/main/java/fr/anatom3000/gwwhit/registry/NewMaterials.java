package fr.anatom3000.gwwhit.registry;

import java.util.ArrayList;
import java.util.List;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import fr.anatom3000.gwwhit.materials.CustomOre;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;

import static fr.anatom3000.gwwhit.materials.CustomOre.*;

@SuppressWarnings("SpellCheckingInspection") //Because custom names
public class NewMaterials {

    public static final NewMaterials INSTANCE = new NewMaterials();
    public final List<CustomOre> ores = new ArrayList<>();

    public NewMaterials() {
        ores.add(new CustomOre("Amader", Type.INGOT, true, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Anaksox", Type.INGOT, true, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Aqyqyf", Type.INGOT, false, true, false, Dimension.END));
        ores.add(new CustomOre("Asymcof", Type.INGOT, false, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Baqi", Type.DUST, false, true, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Botud", Type.GEM, false, true, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Cojos", Type.GEM, false, true, true, Dimension.END));
        ores.add(new CustomOre("Dytap", Type.GEM, false, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Ebeqir", Type.GEM, false, true, true, Dimension.END));
        ores.add(new CustomOre("Ecywygs", Type.GEM, false, true, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Emilamd", Type.INGOT, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Emogy", Type.INGOT, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Emussazr", Type.INGOT, true, true, true, Dimension.END));
        ores.add(new CustomOre("Exuzi", Type.INGOT, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Folso", Type.DUST, false, true, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Foqepm", Type.GEM, false, true, true, Dimension.NETHER));
        ores.add(new CustomOre("Fucox", Type.DUST, false, true, false, Dimension.END));
        ores.add(new CustomOre("Fydif", Type.GEM, false, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Fyfat", Type.GEM, false, true, false, Dimension.END));
        ores.add(new CustomOre("Garar", Type.DUST, false, true, true, Dimension.NETHER));
        ores.add(new CustomOre("Gigyh", Type.GEM, true, false, true, Dimension.END));
        ores.add(new CustomOre("Giry", Type.DUST, true, false, true, Dimension.END));
        ores.add(new CustomOre("Gycu", Type.GEM, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Hoke", Type.DUST, false, false, true, Dimension.END));
        ores.add(new CustomOre("Hugom", Type.DUST, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Icawlu", Type.INGOT, true, true, false, Dimension.END));
        ores.add(new CustomOre("Igekez", Type.INGOT, true, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Ijyqbag", Type.INGOT, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Ikaqajc", Type.GEM, true, false, true, Dimension.END));
        ores.add(new CustomOre("Ipacyk", Type.INGOT, true, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Iqecoln", Type.INGOT, true, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Iqola", Type.INGOT, true, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Izymam", Type.INGOT, true, true, false, Dimension.END));
        ores.add(new CustomOre("Jipna", Type.DUST, true, false, true, Dimension.END));
        ores.add(new CustomOre("Kigys", Type.GEM, true, true, true, Dimension.NETHER));
        ores.add(new CustomOre("Kuqoc", Type.DUST, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Kuzidb", Type.DUST, true, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Lezdor", Type.DUST, true, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Lisluq", Type.GEM, true, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Loded", Type.GEM, true, true, false, Dimension.END));
        ores.add(new CustomOre("Lotih", Type.GEM, false, false, false, Dimension.END));
        ores.add(new CustomOre("Luqysk", Type.GEM, true, false, true, Dimension.END));
        ores.add(new CustomOre("Lysum", Type.GEM, true, true, false, Dimension.END));
        ores.add(new CustomOre("Lywyg", Type.GEM, false, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Mafab", Type.GEM, true, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Mejesh", Type.GEM, true, false, true, Dimension.END));
        ores.add(new CustomOre("Mudatb", Type.GEM, false, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Nafxa", Type.DUST, true, true, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Nefyf", Type.GEM, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Nejun", Type.INGOT, true, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Neqaw", Type.GEM, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Nizuzc", Type.DUST, true, false, false, Dimension.END));
        ores.add(new CustomOre("Notic", Type.DUST, true, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Nugo", Type.DUST, true, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Obaseh", Type.INGOT, false, true, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Obohylp", Type.INGOT, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Obuxan", Type.INGOT, true, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Ohyxfu", Type.INGOT, false, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Opomfam", Type.INGOT, false, false, false, Dimension.END));
        ores.add(new CustomOre("Oquge", Type.INGOT, true, false, false, Dimension.END));
        ores.add(new CustomOre("Otakag", Type.INGOT, false, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Pecced", Type.DUST, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Peqy", Type.GEM, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Ratfyf", Type.DUST, true, true, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Renu", Type.GEM, false, true, true, Dimension.NETHER));
        ores.add(new CustomOre("Rydyrp", Type.GEM, false, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Ryqo", Type.DUST, true, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Senuz", Type.DUST, false, false, true, Dimension.END));
        ores.add(new CustomOre("Sijtyw", Type.GEM, true, true, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Silo", Type.GEM, true, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Soneg", Type.DUST, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Sushehn", Type.GEM, false, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Suwow", Type.DUST, false, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Tefa", Type.DUST, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Tesxes", Type.GEM, false, false, false, Dimension.END));
        ores.add(new CustomOre("Tetus", Type.GEM, false, false, true, Dimension.END));
        ores.add(new CustomOre("Tidziq", Type.GEM, true, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Tifut", Type.INGOT, true, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Tugo", Type.GEM, false, true, false, Dimension.END));
        ores.add(new CustomOre("Tushih", Type.DUST, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Uberteg", Type.INGOT, false, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Uhyqol", Type.INGOT, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Umaboz", Type.INGOT, true, true, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Uruwogq", Type.INGOT, true, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Uwalusq", Type.INGOT, false, true, false, Dimension.END));
        ores.add(new CustomOre("Uwaplok", Type.GEM, false, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Uwygan", Type.INGOT, false, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Uxurup", Type.INGOT, false, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Wekmal", Type.DUST, false, true, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Wemhec", Type.GEM, false, true, true, Dimension.NETHER));
        ores.add(new CustomOre("Wuhitd", Type.DUST, false, false, false, Dimension.END));
        ores.add(new CustomOre("Xugaw", Type.GEM, false, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Yfikal", Type.INGOT, false, true, false, Dimension.NETHER));
        ores.add(new CustomOre("Yjosok", Type.INGOT, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Yjotceh", Type.INGOT, false, false, true, Dimension.NETHER));
        ores.add(new CustomOre("Yqubef", Type.GEM, false, false, true, Dimension.OVERWORLD));
        ores.add(new CustomOre("Ywosduk", Type.INGOT, false, false, false, Dimension.NETHER));
        ores.add(new CustomOre("Zawuf", Type.GEM, false, true, false, Dimension.END));
        ores.add(new CustomOre("Zytu", Type.DUST, false, false, false, Dimension.OVERWORLD));
        ores.add(new CustomOre("Zytutb", Type.DUST, false, false, false, Dimension.END));
    }

    public void onInitialize() {
        OreInitParam param = new OreInitParam();
        for (CustomOre ore : ores) {
            try {
                ore.onInitialize(param);
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }

        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addTag(BlockTags.BEACON_BASE_BLOCKS.getId(), param.blocks);
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addTag(new Identifier("fabric", "items/axes"), param.axes);
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addTag(new Identifier("fabric", "items/hoes"), param.hoes);
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addTag(new Identifier("fabric", "items/pickaxes"), param.pickaxes);
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addTag(new Identifier("fabric", "items/shovels"), param.shovels);
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addTag(new Identifier("fabric", "items/swords"), param.swords);
    }

    public static class OreInitParam {
        public final JTag blocks = JTag.tag();
        public final JTag axes = JTag.tag();
        public final JTag hoes = JTag.tag();
        public final JTag pickaxes = JTag.tag();
        public final JTag shovels = JTag.tag();
        public final JTag swords = JTag.tag();
    }

    public void onInitializeClient() {
        for (CustomOre ore : ores) {
            try {
                ore.onInitializeClient();
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }
    }
}