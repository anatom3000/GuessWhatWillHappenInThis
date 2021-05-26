package fr.anatom3000.gwwhit.materials.yqubef;

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
public class YqubefRoot  {
public static final Yqubef YQUBEF = new Yqubef();
public static final YqubefBlock YQUBEF_BLOCK = new YqubefBlock();
public static final YqubefOre YQUBEF_ORE = new YqubefOre();
public static final YqubefSword YQUBEF_SWORD = new YqubefSword(YqubefMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","yqubef"),YQUBEF);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yqubef_block"), YQUBEF_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yqubef_block"), new BlockItem(YQUBEF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yqubef_ore"), YQUBEF_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yqubef_ore"), new BlockItem(YQUBEF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","yqubef_sword"),YQUBEF_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_yqubef"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}