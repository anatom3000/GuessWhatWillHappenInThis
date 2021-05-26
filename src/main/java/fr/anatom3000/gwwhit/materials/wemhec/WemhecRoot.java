package fr.anatom3000.gwwhit.materials.wemhec;

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
public class WemhecRoot  {
public static final Wemhec WEMHEC = new Wemhec();
public static final WemhecBlock WEMHEC_BLOCK = new WemhecBlock();
public static final WemhecOre WEMHEC_ORE = new WemhecOre();
public static final WemhecShovel WEMHEC_SHOVEL = new WemhecShovel(WemhecMaterial.INSTANCE);
public static final WemhecPickaxe WEMHEC_PICKAXE = new WemhecPickaxe(WemhecMaterial.INSTANCE);
public static final WemhecAxe WEMHEC_AXE = new WemhecAxe(WemhecMaterial.INSTANCE);
public static final WemhecHoe WEMHEC_HOE = new WemhecHoe(WemhecMaterial.INSTANCE);
public static final WemhecSword WEMHEC_SWORD = new WemhecSword(WemhecMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec"),WEMHEC);
FuelRegistry.INSTANCE.add(WEMHEC, 106);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "wemhec_block"), WEMHEC_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "wemhec_block"), new BlockItem(WEMHEC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "wemhec_ore"), WEMHEC_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "wemhec_ore"), new BlockItem(WEMHEC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_shovel"),WEMHEC_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_pickaxe"),WEMHEC_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_axe"),WEMHEC_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_hoe"),WEMHEC_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_sword"),WEMHEC_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_wemhec"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}