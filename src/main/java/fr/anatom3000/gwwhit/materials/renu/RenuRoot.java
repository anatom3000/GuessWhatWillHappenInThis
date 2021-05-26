package fr.anatom3000.gwwhit.materials.renu;

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
public class RenuRoot  {
public static final Renu RENU = new Renu();
public static final RenuBlock RENU_BLOCK = new RenuBlock();
public static final RenuOre RENU_ORE = new RenuOre();
public static final RenuShovel RENU_SHOVEL = new RenuShovel(RenuMaterial.INSTANCE);
public static final RenuPickaxe RENU_PICKAXE = new RenuPickaxe(RenuMaterial.INSTANCE);
public static final RenuAxe RENU_AXE = new RenuAxe(RenuMaterial.INSTANCE);
public static final RenuHoe RENU_HOE = new RenuHoe(RenuMaterial.INSTANCE);
public static final RenuSword RENU_SWORD = new RenuSword(RenuMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu"),RENU);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "renu_block"), RENU_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "renu_block"), new BlockItem(RENU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "renu_ore"), RENU_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "renu_ore"), new BlockItem(RENU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_shovel"),RENU_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_pickaxe"),RENU_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_axe"),RENU_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_hoe"),RENU_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_sword"),RENU_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_renu"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}