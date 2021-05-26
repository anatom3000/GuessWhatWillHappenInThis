package fr.anatom3000.gwwhit.materials.neqaw;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
public class NeqawRoot  {
public static final Neqaw NEQAW = new Neqaw();
public static final NeqawBlock NEQAW_BLOCK = new NeqawBlock();
public static final NeqawOre NEQAW_ORE = new NeqawOre();
public static final ArmorMaterial neqawArmorMaterial = new NeqawArmorMaterial();
public static final NeqawHelmet NEQAW_HELMET = new NeqawHelmet(neqawArmorMaterial);
public static final NeqawChestplate NEQAW_CHESTPLATE = new NeqawChestplate(neqawArmorMaterial);
public static final NeqawLeggings NEQAW_LEGGINGS = new NeqawLeggings(neqawArmorMaterial);
public static final NeqawBoots NEQAW_BOOTS = new NeqawBoots(neqawArmorMaterial);
public static final NeqawSword NEQAW_SWORD = new NeqawSword(NeqawMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","neqaw"),NEQAW);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "neqaw_block"), NEQAW_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_block"), new BlockItem(NEQAW_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "neqaw_ore"), NEQAW_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_ore"), new BlockItem(NEQAW_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","neqaw_helmet"),NEQAW_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","neqaw_chestplate"),NEQAW_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","neqaw_leggings"),NEQAW_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","neqaw_boots"),NEQAW_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","neqaw_sword"),NEQAW_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_neqaw"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}