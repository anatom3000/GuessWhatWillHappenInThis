package fr.anatom3000.gwwhit.materials.zytu;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class ZytuRoot  {
public static final ZytuDust ZYTU_DUST = new ZytuDust();
public static final ZytuBlock ZYTU_BLOCK = new ZytuBlock();
public static final ZytuOre ZYTU_ORE = new ZytuOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","zytu_dust"),ZYTU_DUST);
FuelRegistry.INSTANCE.add(ZYTU_DUST, 829);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "zytu_block"), ZYTU_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "zytu_block"), new BlockItem(ZYTU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "zytu_ore"), ZYTU_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "zytu_ore"), new BlockItem(ZYTU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_zytu"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}