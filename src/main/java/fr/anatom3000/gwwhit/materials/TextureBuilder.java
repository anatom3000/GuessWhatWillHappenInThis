package fr.anatom3000.gwwhit.materials;

import fr.anatom3000.gwwhit.GWWHIT;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class TextureBuilder {
    public static void generateOre(int color, Identifier id, String baseBlock, Random rng) {
        try {
            retextureMerge(
                    id,
                    FabricLoader.getInstance().getModContainer("minecraft").orElseThrow()
                        .getPath("assets/minecraft/textures/block/" + baseBlock + ".png"),
                    "textures/block/ore" + (rng.nextInt(49) + 1),
                    color
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateOreBlock(int color, Identifier id, Random rng) {
        try {
            simpleRetexture(id, "textures/block/oreblock" + (rng.nextInt(27) + 1), color);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateArmor(int color, String name, Random rng) {
        try {
            int t = rng.nextInt(2) + 1;
            for (CustomOre.ArmorType type : CustomOre.ArmorType.values()) {
                String tn = type.name().toLowerCase();
                simpleRetexture(GWWHIT.getId("item/" + name + "_" + tn), "textures/item/" + tn + t, color);
            }
            simpleRetexture(
                    new Identifier("minecraft", "models/armor/" + name + "_layer_1"),
                    "textures/misc/layer_1" + t,
                    color
            );
            simpleRetexture(
                    new Identifier("minecraft", "models/armor/" + name + "_layer_2"),
                    "textures/misc/layer_2" + t,
                    color
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateMaterial(int color, Identifier id, CustomOre.Type type, Random rng) {
        try {
            simpleRetexture(id, "textures/item/" + type.name().toLowerCase() + (rng.nextInt(switch (type) {
                case GEM -> 40;
                case DUST -> 11;
                case INGOT -> 19;
            }) + 1), color);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateTool(int color, Identifier id, ToolType type, Random rng) {
        try {
            String n = type == ToolType.SHOVEL ? "tool_base_shovel" : "tool_base";
            retextureMerge(
                    id,
                    GWWHIT.ASSETS_ROOT.resolve("textures/item/" + n + ".png"),
                    "textures/item/tool_" + type.name().toLowerCase() + (
                            rng.nextInt(
                                    switch (type) {
                                        case SWORD -> 1;
                                        case SHOVEL -> 1;
                                        case AXE -> 12;
                                        case PICKAXE -> 12;
                                        case HOE -> 11;
                                    }
                            ) + 1
                    ),
                    color
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void retextureMerge(Identifier id, Path base, String upper, int tint) throws IOException {
        try (InputStream is = Files.newInputStream(base);
             InputStream isOverlay = Files.newInputStream(GWWHIT.ASSETS_ROOT.resolve(upper + ".png"))
        ) {
            BufferedImage img = ImageIO.read(is);
            BufferedImage imgOverlay = ImageIO.read(isOverlay);
            for (int y = 0; y < 16; y++) {
                for (int x = 0; x < 16; x++) {
                    img.setRGB(x, y, layer(img.getRGB(x, y), tint(imgOverlay.getRGB(x, y), tint)));
                }
            }
            GWWHIT.RESOURCE_PACK.addTexture(id, img);
        }
    }

    private static void simpleRetexture(Identifier id, String origin, int tint) throws IOException {
        InputStream base = Files.newInputStream(GWWHIT.ASSETS_ROOT.resolve(origin + ".png"));
        GWWHIT.RESOURCE_PACK.addRecoloredImage(id, base, i -> tint(i, tint));
    }

    private static int layer(int base, int layer) {
        int al = getAlpha(layer);
        int r = (getRed(base) * (255 - al) + getRed(layer) * al) / 255;
        int g = (getGreen(base) * (255 - al) + getGreen(layer) * al) / 255;
        int b = (getBlue(base) * (255 - al) + getBlue(layer) * al) / 255;
        int a = getAlpha(base) | al;
        return combine(r, g, b, a);
    }

    private static int tint(int col, int tint) {
        int r = (getRed(col) + getRed(tint)) / 2;
        int g = (getGreen(col) + getGreen(tint)) / 2;
        int b = (getBlue(col) + getBlue(tint)) / 2;
        int a = getAlpha(col);
        return combine(r, g, b, a);
    }

    private static int getRed(int col) {
        return (col >> 16) & 0xFF;
    }

    private static int getGreen(int col) {
        return (col >> 8) & 0xFF;
    }

    private static int getBlue(int col) {
        return (col) & 0xFF;
    }

    private static int getAlpha(int col) {
        return (col >> 24) & 0xff;
    }

    private static int combine(int r, int g, int b, int a) {
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    public enum ToolType {
        SWORD, SHOVEL, AXE, PICKAXE, HOE
    }
}
