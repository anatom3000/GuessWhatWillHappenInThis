package fr.anatom3000.gwwhit.materials.emussazr;

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
public class EmussazrRoot  {
public static final EmussazrIngot EMUSSAZR_INGOT = new EmussazrIngot();
public static final EmussazrBlock EMUSSAZR_BLOCK = new EmussazrBlock();
public static final EmussazrOre EMUSSAZR_ORE = new EmussazrOre();
public static final EmussazrShovel EMUSSAZR_SHOVEL = new EmussazrShovel(EmussazrMaterial.INSTANCE);
public static final EmussazrPickaxe EMUSSAZR_PICKAXE = new EmussazrPickaxe(EmussazrMaterial.INSTANCE);
public static final EmussazrAxe EMUSSAZR_AXE = new EmussazrAxe(EmussazrMaterial.INSTANCE);
public static final EmussazrHoe EMUSSAZR_HOE = new EmussazrHoe(EmussazrMaterial.INSTANCE);
public static final ArmorMaterial emussazrArmorMaterial = new EmussazrArmorMaterial();
public static final EmussazrHelmet EMUSSAZR_HELMET = new EmussazrHelmet(emussazrArmorMaterial);
public static final EmussazrChestplate EMUSSAZR_CHESTPLATE = new EmussazrChestplate(emussazrArmorMaterial);
public static final EmussazrLeggings EMUSSAZR_LEGGINGS = new EmussazrLeggings(emussazrArmorMaterial);
public static final EmussazrBoots EMUSSAZR_BOOTS = new EmussazrBoots(emussazrArmorMaterial);
public static final EmussazrSword EMUSSAZR_SWORD = new EmussazrSword(EmussazrMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_ingot"),EMUSSAZR_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "emussazr_block"), EMUSSAZR_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "emussazr_block"), new BlockItem(EMUSSAZR_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "emussazr_ore"), EMUSSAZR_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "emussazr_ore"), new BlockItem(EMUSSAZR_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_shovel"),EMUSSAZR_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_pickaxe"),EMUSSAZR_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_axe"),EMUSSAZR_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_hoe"),EMUSSAZR_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_helmet"),EMUSSAZR_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_chestplate"),EMUSSAZR_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_leggings"),EMUSSAZR_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_boots"),EMUSSAZR_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emussazr_sword"),EMUSSAZR_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_emussazr"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}