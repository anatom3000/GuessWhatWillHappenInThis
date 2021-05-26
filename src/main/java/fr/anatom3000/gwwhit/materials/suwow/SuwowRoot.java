package fr.anatom3000.gwwhit.materials.suwow;

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
public class SuwowRoot  {
public static final SuwowDust SUWOW_DUST = new SuwowDust();
public static final SuwowBlock SUWOW_BLOCK = new SuwowBlock();
public static final SuwowOre SUWOW_ORE = new SuwowOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","suwow_dust"),SUWOW_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "suwow_block"), SUWOW_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "suwow_block"), new BlockItem(SUWOW_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "suwow_ore"), SUWOW_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "suwow_ore"), new BlockItem(SUWOW_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_suwow"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}