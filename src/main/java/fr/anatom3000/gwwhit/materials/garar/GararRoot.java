package fr.anatom3000.gwwhit.materials.garar;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class GararRoot  {
public static final GararDust GARAR_DUST = new GararDust();
public static final GararBlock GARAR_BLOCK = new GararBlock();
public static final GararOre GARAR_ORE = new GararOre();
public static final GararShovel GARAR_SHOVEL = new GararShovel(GararMaterial.INSTANCE);
public static final GararPickaxe GARAR_PICKAXE = new GararPickaxe(GararMaterial.INSTANCE);
public static final GararAxe GARAR_AXE = new GararAxe(GararMaterial.INSTANCE);
public static final GararHoe GARAR_HOE = new GararHoe(GararMaterial.INSTANCE);
public static final GararSword GARAR_SWORD = new GararSword(GararMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","garar_dust"),GARAR_DUST);
FuelRegistry.INSTANCE.add(GARAR_DUST, 123);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "garar_block"), GARAR_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "garar_block"), new BlockItem(GARAR_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "garar_ore"), GARAR_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "garar_ore"), new BlockItem(GARAR_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","garar_shovel"),GARAR_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","garar_pickaxe"),GARAR_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","garar_axe"),GARAR_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","garar_hoe"),GARAR_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","garar_sword"),GARAR_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_garar"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}