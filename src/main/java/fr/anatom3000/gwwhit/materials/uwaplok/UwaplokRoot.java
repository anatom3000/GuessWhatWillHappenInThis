package fr.anatom3000.gwwhit.materials.uwaplok;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
public class UwaplokRoot  {
public static final Uwaplok UWAPLOK = new Uwaplok();
public static final UwaplokBlock UWAPLOK_BLOCK = new UwaplokBlock();
public static final UwaplokOre UWAPLOK_ORE = new UwaplokOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwaplok"),UWAPLOK);
FuelRegistry.INSTANCE.add(UWAPLOK, 397);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwaplok_block"), UWAPLOK_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwaplok_block"), new BlockItem(UWAPLOK_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwaplok_ore"), UWAPLOK_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwaplok_ore"), new BlockItem(UWAPLOK_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uwaplok"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}