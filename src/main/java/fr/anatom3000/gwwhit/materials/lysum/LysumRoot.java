package fr.anatom3000.gwwhit.materials.lysum;

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
public class LysumRoot  {
public static final Lysum LYSUM = new Lysum();
public static final LysumBlock LYSUM_BLOCK = new LysumBlock();
public static final LysumOre LYSUM_ORE = new LysumOre();
public static final LysumShovel LYSUM_SHOVEL = new LysumShovel(LysumMaterial.INSTANCE);
public static final LysumPickaxe LYSUM_PICKAXE = new LysumPickaxe(LysumMaterial.INSTANCE);
public static final LysumAxe LYSUM_AXE = new LysumAxe(LysumMaterial.INSTANCE);
public static final LysumHoe LYSUM_HOE = new LysumHoe(LysumMaterial.INSTANCE);
public static final ArmorMaterial lysumArmorMaterial = new LysumArmorMaterial();
public static final LysumHelmet LYSUM_HELMET = new LysumHelmet(lysumArmorMaterial);
public static final LysumChestplate LYSUM_CHESTPLATE = new LysumChestplate(lysumArmorMaterial);
public static final LysumLeggings LYSUM_LEGGINGS = new LysumLeggings(lysumArmorMaterial);
public static final LysumBoots LYSUM_BOOTS = new LysumBoots(lysumArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum"),LYSUM);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lysum_block"), LYSUM_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lysum_block"), new BlockItem(LYSUM_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lysum_ore"), LYSUM_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lysum_ore"), new BlockItem(LYSUM_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum_shovel"),LYSUM_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum_pickaxe"),LYSUM_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum_axe"),LYSUM_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum_hoe"),LYSUM_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum_helmet"),LYSUM_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum_chestplate"),LYSUM_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum_leggings"),LYSUM_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lysum_boots"),LYSUM_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_lysum"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}