package fr.anatom3000.gwwhit.materials.wuhitd;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class WuhitdRoot  {
public static final WuhitdDust WUHITD_DUST = new WuhitdDust();
public static final WuhitdBlock WUHITD_BLOCK = new WuhitdBlock();
public static final WuhitdOre WUHITD_ORE = new WuhitdOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","wuhitd_dust"),WUHITD_DUST);
FuelRegistry.INSTANCE.add(WUHITD_DUST, 853);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "wuhitd_block"), WUHITD_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "wuhitd_block"), new BlockItem(WUHITD_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "wuhitd_ore"), WUHITD_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "wuhitd_ore"), new BlockItem(WUHITD_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_wuhitd"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}