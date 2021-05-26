package fr.anatom3000.gwwhit.materials.lezdor;

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
public class LezdorRoot  {
public static final LezdorDust LEZDOR_DUST = new LezdorDust();
public static final LezdorBlock LEZDOR_BLOCK = new LezdorBlock();
public static final LezdorOre LEZDOR_ORE = new LezdorOre();
public static final ArmorMaterial lezdorArmorMaterial = new LezdorArmorMaterial();
public static final LezdorHelmet LEZDOR_HELMET = new LezdorHelmet(lezdorArmorMaterial);
public static final LezdorChestplate LEZDOR_CHESTPLATE = new LezdorChestplate(lezdorArmorMaterial);
public static final LezdorLeggings LEZDOR_LEGGINGS = new LezdorLeggings(lezdorArmorMaterial);
public static final LezdorBoots LEZDOR_BOOTS = new LezdorBoots(lezdorArmorMaterial);
public static final LezdorSword LEZDOR_SWORD = new LezdorSword(LezdorMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_dust"),LEZDOR_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lezdor_block"), LEZDOR_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lezdor_block"), new BlockItem(LEZDOR_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lezdor_ore"), LEZDOR_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lezdor_ore"), new BlockItem(LEZDOR_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_helmet"),LEZDOR_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_chestplate"),LEZDOR_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_leggings"),LEZDOR_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_boots"),LEZDOR_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_sword"),LEZDOR_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_lezdor"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}