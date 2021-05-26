package fr.anatom3000.gwwhit.materials.amader;

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
public class AmaderRoot  {
public static final AmaderIngot AMADER_INGOT = new AmaderIngot();
public static final AmaderBlock AMADER_BLOCK = new AmaderBlock();
public static final AmaderOre AMADER_ORE = new AmaderOre();
public static final AmaderShovel AMADER_SHOVEL = new AmaderShovel(AmaderMaterial.INSTANCE);
public static final AmaderPickaxe AMADER_PICKAXE = new AmaderPickaxe(AmaderMaterial.INSTANCE);
public static final AmaderAxe AMADER_AXE = new AmaderAxe(AmaderMaterial.INSTANCE);
public static final AmaderHoe AMADER_HOE = new AmaderHoe(AmaderMaterial.INSTANCE);
public static final ArmorMaterial amaderArmorMaterial = new AmaderArmorMaterial();
public static final AmaderHelmet AMADER_HELMET = new AmaderHelmet(amaderArmorMaterial);
public static final AmaderChestplate AMADER_CHESTPLATE = new AmaderChestplate(amaderArmorMaterial);
public static final AmaderLeggings AMADER_LEGGINGS = new AmaderLeggings(amaderArmorMaterial);
public static final AmaderBoots AMADER_BOOTS = new AmaderBoots(amaderArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_ingot"),AMADER_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "amader_block"), AMADER_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "amader_block"), new BlockItem(AMADER_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "amader_ore"), AMADER_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "amader_ore"), new BlockItem(AMADER_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_shovel"),AMADER_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_pickaxe"),AMADER_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_axe"),AMADER_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_hoe"),AMADER_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_helmet"),AMADER_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_chestplate"),AMADER_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_leggings"),AMADER_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_boots"),AMADER_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_amader"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}