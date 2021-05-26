package fr.anatom3000.gwwhit.materials.luqysk;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
public class LuqyskRoot  {
public static final Luqysk LUQYSK = new Luqysk();
public static final LuqyskBlock LUQYSK_BLOCK = new LuqyskBlock();
public static final LuqyskOre LUQYSK_ORE = new LuqyskOre();
public static final ArmorMaterial luqyskArmorMaterial = new LuqyskArmorMaterial();
public static final LuqyskHelmet LUQYSK_HELMET = new LuqyskHelmet(luqyskArmorMaterial);
public static final LuqyskChestplate LUQYSK_CHESTPLATE = new LuqyskChestplate(luqyskArmorMaterial);
public static final LuqyskLeggings LUQYSK_LEGGINGS = new LuqyskLeggings(luqyskArmorMaterial);
public static final LuqyskBoots LUQYSK_BOOTS = new LuqyskBoots(luqyskArmorMaterial);
public static final LuqyskSword LUQYSK_SWORD = new LuqyskSword(LuqyskMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk"),LUQYSK);
FuelRegistry.INSTANCE.add(LUQYSK, 117);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "luqysk_block"), LUQYSK_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "luqysk_block"), new BlockItem(LUQYSK_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "luqysk_ore"), LUQYSK_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "luqysk_ore"), new BlockItem(LUQYSK_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_helmet"),LUQYSK_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_chestplate"),LUQYSK_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_leggings"),LUQYSK_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_boots"),LUQYSK_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_sword"),LUQYSK_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_luqysk"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}