package fr.anatom3000.gwwhit.materials.uwalusq;

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
public class UwalusqRoot  {
public static final UwalusqIngot UWALUSQ_INGOT = new UwalusqIngot();
public static final UwalusqBlock UWALUSQ_BLOCK = new UwalusqBlock();
public static final UwalusqOre UWALUSQ_ORE = new UwalusqOre();
public static final UwalusqShovel UWALUSQ_SHOVEL = new UwalusqShovel(UwalusqMaterial.INSTANCE);
public static final UwalusqPickaxe UWALUSQ_PICKAXE = new UwalusqPickaxe(UwalusqMaterial.INSTANCE);
public static final UwalusqAxe UWALUSQ_AXE = new UwalusqAxe(UwalusqMaterial.INSTANCE);
public static final UwalusqHoe UWALUSQ_HOE = new UwalusqHoe(UwalusqMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_ingot"),UWALUSQ_INGOT);
FuelRegistry.INSTANCE.add(UWALUSQ_INGOT, 171);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwalusq_block"), UWALUSQ_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwalusq_block"), new BlockItem(UWALUSQ_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwalusq_ore"), UWALUSQ_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwalusq_ore"), new BlockItem(UWALUSQ_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_shovel"),UWALUSQ_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_pickaxe"),UWALUSQ_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_axe"),UWALUSQ_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_hoe"),UWALUSQ_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uwalusq"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}