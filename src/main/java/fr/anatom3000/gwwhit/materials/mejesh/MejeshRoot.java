package fr.anatom3000.gwwhit.materials.mejesh;

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
public class MejeshRoot  {
public static final Mejesh MEJESH = new Mejesh();
public static final MejeshBlock MEJESH_BLOCK = new MejeshBlock();
public static final MejeshOre MEJESH_ORE = new MejeshOre();
public static final ArmorMaterial mejeshArmorMaterial = new MejeshArmorMaterial();
public static final MejeshHelmet MEJESH_HELMET = new MejeshHelmet(mejeshArmorMaterial);
public static final MejeshChestplate MEJESH_CHESTPLATE = new MejeshChestplate(mejeshArmorMaterial);
public static final MejeshLeggings MEJESH_LEGGINGS = new MejeshLeggings(mejeshArmorMaterial);
public static final MejeshBoots MEJESH_BOOTS = new MejeshBoots(mejeshArmorMaterial);
public static final MejeshSword MEJESH_SWORD = new MejeshSword(MejeshMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","mejesh"),MEJESH);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "mejesh_block"), MEJESH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "mejesh_block"), new BlockItem(MEJESH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "mejesh_ore"), MEJESH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "mejesh_ore"), new BlockItem(MEJESH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","mejesh_helmet"),MEJESH_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mejesh_chestplate"),MEJESH_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mejesh_leggings"),MEJESH_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mejesh_boots"),MEJESH_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mejesh_sword"),MEJESH_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_mejesh"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}