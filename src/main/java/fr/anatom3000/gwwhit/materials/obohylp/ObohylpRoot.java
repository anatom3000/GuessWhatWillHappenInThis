package fr.anatom3000.gwwhit.materials.obohylp;

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
public class ObohylpRoot  {
public static final ObohylpIngot OBOHYLP_INGOT = new ObohylpIngot();
public static final ObohylpBlock OBOHYLP_BLOCK = new ObohylpBlock();
public static final ObohylpOre OBOHYLP_ORE = new ObohylpOre();
public static final ObohylpSword OBOHYLP_SWORD = new ObohylpSword(ObohylpMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","obohylp_ingot"),OBOHYLP_INGOT);
FuelRegistry.INSTANCE.add(OBOHYLP_INGOT, 919);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "obohylp_block"), OBOHYLP_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "obohylp_block"), new BlockItem(OBOHYLP_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "obohylp_ore"), OBOHYLP_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "obohylp_ore"), new BlockItem(OBOHYLP_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","obohylp_sword"),OBOHYLP_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_obohylp"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}