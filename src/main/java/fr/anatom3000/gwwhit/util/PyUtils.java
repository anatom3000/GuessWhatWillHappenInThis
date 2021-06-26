package fr.anatom3000.gwwhit.util;

import net.minecraft.block.Material;
import net.minecraft.util.Identifier;

public final class PyUtils {
    public static Material getMaterial(String name) {
        return switch (name) {
            case "stone" -> Material.STONE;
            case "water" -> Material.WATER;
            case "ICE" -> Material.ICE;
            case "soil" -> Material.SOIL;
            case "solid_organic" -> Material.SOLID_ORGANIC;
            default -> Material.AIR;
        };
    }

    public static Identifier makeIdentifier(String namespace, String path) {
        return new Identifier(namespace, path);
    }
}
