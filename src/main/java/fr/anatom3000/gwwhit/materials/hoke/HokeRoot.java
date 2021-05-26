package fr.anatom3000.gwwhit.materials.hoke;

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
public class HokeRoot  {
public static final HokeDust HOKE_DUST = new HokeDust();
public static final HokeBlock HOKE_BLOCK = new HokeBlock();
public static final HokeOre HOKE_ORE = new HokeOre();
public static final HokeSword HOKE_SWORD = new HokeSword(HokeMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","hoke_dust"),HOKE_DUST);
FuelRegistry.INSTANCE.add(HOKE_DUST, 515);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "hoke_block"), HOKE_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "hoke_block"), new BlockItem(HOKE_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "hoke_ore"), HOKE_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "hoke_ore"), new BlockItem(HOKE_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","hoke_sword"),HOKE_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_hoke"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}