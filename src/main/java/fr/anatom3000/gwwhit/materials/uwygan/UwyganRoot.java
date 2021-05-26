package fr.anatom3000.gwwhit.materials.uwygan;

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
public class UwyganRoot  {
public static final UwyganIngot UWYGAN_INGOT = new UwyganIngot();
public static final UwyganBlock UWYGAN_BLOCK = new UwyganBlock();
public static final UwyganOre UWYGAN_ORE = new UwyganOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwygan_ingot"),UWYGAN_INGOT);
FuelRegistry.INSTANCE.add(UWYGAN_INGOT, 667);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwygan_block"), UWYGAN_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwygan_block"), new BlockItem(UWYGAN_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwygan_ore"), UWYGAN_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwygan_ore"), new BlockItem(UWYGAN_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uwygan"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}