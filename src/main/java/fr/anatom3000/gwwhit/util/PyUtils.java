package fr.anatom3000.gwwhit.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;

public final class PyUtils {

	public static Material getMaterial(String name) {
		switch (name) {
			case "stone":
				return Material.STONE;
			case "water":
				return Material.WATER;
			case "ICE":
				return Material.ICE;
			case "soil":
				return Material.SOIL;
			case "solid_organic":
				return Material.SOLID_ORGANIC;
			default:
				return Material.AIR;
		}
	}

	public static Identifier makeIdentifier(String namespace, String path) {
		return new Identifier(namespace, path);
	}



}
