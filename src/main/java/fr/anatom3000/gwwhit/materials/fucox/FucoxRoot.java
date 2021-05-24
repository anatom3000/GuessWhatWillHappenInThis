package fr.anatom3000.gwwhit.materials.fucox;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class FucoxRoot  {
public static final FucoxDust FUCOX_DUST = new FucoxDust();
public static final FucoxBlock FUCOX_BLOCK = new FucoxBlock();
public static final FucoxOre FUCOX_ORE = new FucoxOre();
public static final FucoxShovel FUCOX_SHOVEL = new FucoxShovel(FucoxMaterial.INSTANCE);
public static final FucoxPickaxe FUCOX_PICKAXE = new FucoxPickaxe(FucoxMaterial.INSTANCE);
public static final FucoxAxe FUCOX_AXE = new FucoxAxe(FucoxMaterial.INSTANCE);
public static final FucoxHoe FUCOX_HOE = new FucoxHoe(FucoxMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_dust"),FUCOX_DUST);
FuelRegistry.INSTANCE.add(FUCOX_DUST, 897);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fucox_block"), FUCOX_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fucox_block"), new BlockItem(FUCOX_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fucox_ore"), FUCOX_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fucox_ore"), new BlockItem(FUCOX_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_shovel"),FUCOX_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_pickaxe"),FUCOX_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_axe"),FUCOX_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_hoe"),FUCOX_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_fucox"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}