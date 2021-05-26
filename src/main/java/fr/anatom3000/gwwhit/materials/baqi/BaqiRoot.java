package fr.anatom3000.gwwhit.materials.baqi;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
public class BaqiRoot  {
public static final BaqiDust BAQI_DUST = new BaqiDust();
public static final BaqiBlock BAQI_BLOCK = new BaqiBlock();
public static final BaqiOre BAQI_ORE = new BaqiOre();
public static final BaqiShovel BAQI_SHOVEL = new BaqiShovel(BaqiMaterial.INSTANCE);
public static final BaqiPickaxe BAQI_PICKAXE = new BaqiPickaxe(BaqiMaterial.INSTANCE);
public static final BaqiAxe BAQI_AXE = new BaqiAxe(BaqiMaterial.INSTANCE);
public static final BaqiHoe BAQI_HOE = new BaqiHoe(BaqiMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_dust"),BAQI_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "baqi_block"), BAQI_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "baqi_block"), new BlockItem(BAQI_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "baqi_ore"), BAQI_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "baqi_ore"), new BlockItem(BAQI_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_shovel"),BAQI_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_pickaxe"),BAQI_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_axe"),BAQI_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_hoe"),BAQI_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_baqi"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}