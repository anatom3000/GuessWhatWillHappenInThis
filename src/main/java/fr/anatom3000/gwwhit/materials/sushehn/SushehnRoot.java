package fr.anatom3000.gwwhit.materials.sushehn;

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
public class SushehnRoot  {
public static final Sushehn SUSHEHN = new Sushehn();
public static final SushehnBlock SUSHEHN_BLOCK = new SushehnBlock();
public static final SushehnOre SUSHEHN_ORE = new SushehnOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","sushehn"),SUSHEHN);
FuelRegistry.INSTANCE.add(SUSHEHN, 101);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "sushehn_block"), SUSHEHN_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "sushehn_block"), new BlockItem(SUSHEHN_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "sushehn_ore"), SUSHEHN_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "sushehn_ore"), new BlockItem(SUSHEHN_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_sushehn"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}