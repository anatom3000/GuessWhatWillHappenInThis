package fr.anatom3000.gwwhit.materials.nizuzc;

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
public class NizuzcRoot  {
public static final NizuzcDust NIZUZC_DUST = new NizuzcDust();
public static final NizuzcBlock NIZUZC_BLOCK = new NizuzcBlock();
public static final NizuzcOre NIZUZC_ORE = new NizuzcOre();
public static final ArmorMaterial nizuzcArmorMaterial = new NizuzcArmorMaterial();
public static final NizuzcHelmet NIZUZC_HELMET = new NizuzcHelmet(nizuzcArmorMaterial);
public static final NizuzcChestplate NIZUZC_CHESTPLATE = new NizuzcChestplate(nizuzcArmorMaterial);
public static final NizuzcLeggings NIZUZC_LEGGINGS = new NizuzcLeggings(nizuzcArmorMaterial);
public static final NizuzcBoots NIZUZC_BOOTS = new NizuzcBoots(nizuzcArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_dust"),NIZUZC_DUST);
FuelRegistry.INSTANCE.add(NIZUZC_DUST, 135);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nizuzc_block"), NIZUZC_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nizuzc_block"), new BlockItem(NIZUZC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nizuzc_ore"), NIZUZC_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nizuzc_ore"), new BlockItem(NIZUZC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_helmet"),NIZUZC_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_chestplate"),NIZUZC_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_leggings"),NIZUZC_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_boots"),NIZUZC_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_nizuzc"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}