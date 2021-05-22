package fr.anatom3000.gwwhit.materials.uxurup;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class UxurupRoot  {
public static final UxurupIngot UXURUP_INGOT = new UxurupIngot();
public static final UxurupBlock UXURUP_BLOCK = new UxurupBlock();
public static final UxurupOre UXURUP_ORE = new UxurupOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uxurup_ingot"),UXURUP_INGOT);
FuelRegistry.INSTANCE.add(UXURUP_INGOT, 514);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uxurup_block"), UXURUP_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uxurup_block"), new BlockItem(UXURUP_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uxurup_ore"), UXURUP_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uxurup_ore"), new BlockItem(UXURUP_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uxurup"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}