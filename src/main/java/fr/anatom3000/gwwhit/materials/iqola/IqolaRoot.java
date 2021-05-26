package fr.anatom3000.gwwhit.materials.iqola;

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
public class IqolaRoot  {
public static final IqolaIngot IQOLA_INGOT = new IqolaIngot();
public static final IqolaBlock IQOLA_BLOCK = new IqolaBlock();
public static final IqolaOre IQOLA_ORE = new IqolaOre();
public static final ArmorMaterial iqolaArmorMaterial = new IqolaArmorMaterial();
public static final IqolaHelmet IQOLA_HELMET = new IqolaHelmet(iqolaArmorMaterial);
public static final IqolaChestplate IQOLA_CHESTPLATE = new IqolaChestplate(iqolaArmorMaterial);
public static final IqolaLeggings IQOLA_LEGGINGS = new IqolaLeggings(iqolaArmorMaterial);
public static final IqolaBoots IQOLA_BOOTS = new IqolaBoots(iqolaArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_ingot"),IQOLA_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "iqola_block"), IQOLA_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqola_block"), new BlockItem(IQOLA_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "iqola_ore"), IQOLA_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqola_ore"), new BlockItem(IQOLA_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_helmet"),IQOLA_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_chestplate"),IQOLA_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_leggings"),IQOLA_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_boots"),IQOLA_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_iqola"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}