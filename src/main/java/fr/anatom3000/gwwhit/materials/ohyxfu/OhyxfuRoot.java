package fr.anatom3000.gwwhit.materials.ohyxfu;

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
public class OhyxfuRoot  {
public static final OhyxfuIngot OHYXFU_INGOT = new OhyxfuIngot();
public static final OhyxfuBlock OHYXFU_BLOCK = new OhyxfuBlock();
public static final OhyxfuOre OHYXFU_ORE = new OhyxfuOre();
public static final OhyxfuSword OHYXFU_SWORD = new OhyxfuSword(OhyxfuMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","ohyxfu_ingot"),OHYXFU_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ohyxfu_block"), OHYXFU_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ohyxfu_block"), new BlockItem(OHYXFU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ohyxfu_ore"), OHYXFU_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ohyxfu_ore"), new BlockItem(OHYXFU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","ohyxfu_sword"),OHYXFU_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_ohyxfu"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}