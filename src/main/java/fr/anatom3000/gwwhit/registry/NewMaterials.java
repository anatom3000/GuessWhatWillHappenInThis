package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.materials.CustomOre;
import fr.anatom3000.gwwhit.materials.CustomOre.Dimension;
import fr.anatom3000.gwwhit.materials.CustomOre.Type;
import fr.anatom3000.gwwhit.util.NameGenerator;
import net.devtech.arrp.json.lang.JLang;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.*;

public class NewMaterials {
    public static final List<CustomOre> ores = new ArrayList<>();

    static {
        int count = ConfigManager.getActiveConfig().moreOres.oresCount;
        Random rng = new Random(ConfigManager.getActiveConfig().moreOres.seed);
        for (int i = 0; i < count; i++) {
            ores.add(new CustomOre(NameGenerator.generateOreName(rng),
                    Type.values()[rng.nextInt(Type.values().length)],
                    rng,
                    rng.nextBoolean(),
                    rng.nextBoolean(),
                    rng.nextBoolean(),
                    Dimension.values()[rng.nextInt(Dimension.values().length)],
                    DyeColor.values()[rng.nextInt(DyeColor.values().length)]));
        }
    }

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

        GWWHIT.RESOURCE_PACK.addTag(new Identifier("minecraft", "blocks/mineable/pickaxe"), param.mineablePickaxe);
        GWWHIT.RESOURCE_PACK.addTag(new Identifier("minecraft", "blocks/needs_stone_tool"), param.needsStoneTool);
        GWWHIT.RESOURCE_PACK.addTag(new Identifier("minecraft", "blocks/needs_iron_tool"), param.needsIronTool);
        GWWHIT.RESOURCE_PACK.addTag(new Identifier("minecraft", "blocks/needs_diamond_tool"), param.needsDiamondTool);
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

    public static class OreInitParam {
        public final JTag blocks = JTag.tag();
        public final JTag axes = JTag.tag();
        public final JTag hoes = JTag.tag();
        public final JTag pickaxes = JTag.tag();
        public final JTag shovels = JTag.tag();
        public final JTag swords = JTag.tag();
        public final JTag mineablePickaxe = JTag.tag();
        public final JTag needsStoneTool = JTag.tag();
        public final JTag needsIronTool = JTag.tag();
        public final JTag needsDiamondTool = JTag.tag();
        public final Map<String, JLang> lang = new HashMap<>();
    }
}
