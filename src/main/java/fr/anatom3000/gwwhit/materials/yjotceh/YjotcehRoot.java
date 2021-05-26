package fr.anatom3000.gwwhit.materials.yjotceh;

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
public class YjotcehRoot  {
public static final YjotcehIngot YJOTCEH_INGOT = new YjotcehIngot();
public static final YjotcehBlock YJOTCEH_BLOCK = new YjotcehBlock();
public static final YjotcehOre YJOTCEH_ORE = new YjotcehOre();
public static final YjotcehSword YJOTCEH_SWORD = new YjotcehSword(YjotcehMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","yjotceh_ingot"),YJOTCEH_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yjotceh_block"), YJOTCEH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yjotceh_block"), new BlockItem(YJOTCEH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yjotceh_ore"), YJOTCEH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yjotceh_ore"), new BlockItem(YJOTCEH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","yjotceh_sword"),YJOTCEH_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_yjotceh"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}