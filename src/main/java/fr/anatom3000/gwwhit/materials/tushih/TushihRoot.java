package fr.anatom3000.gwwhit.materials.tushih;

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
public class TushihRoot  {
public static final TushihDust TUSHIH_DUST = new TushihDust();
public static final TushihBlock TUSHIH_BLOCK = new TushihBlock();
public static final TushihOre TUSHIH_ORE = new TushihOre();
public static final TushihSword TUSHIH_SWORD = new TushihSword(TushihMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","tushih_dust"),TUSHIH_DUST);
FuelRegistry.INSTANCE.add(TUSHIH_DUST, 963);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tushih_block"), TUSHIH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tushih_block"), new BlockItem(TUSHIH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tushih_ore"), TUSHIH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tushih_ore"), new BlockItem(TUSHIH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","tushih_sword"),TUSHIH_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_tushih"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}