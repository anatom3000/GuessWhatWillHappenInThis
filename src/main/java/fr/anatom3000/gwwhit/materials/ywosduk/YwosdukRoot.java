package fr.anatom3000.gwwhit.materials.ywosduk;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class YwosdukRoot  {
public static final YwosdukIngot YWOSDUK_INGOT = new YwosdukIngot();
public static final YwosdukBlock YWOSDUK_BLOCK = new YwosdukBlock();
public static final YwosdukOre YWOSDUK_ORE = new YwosdukOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","ywosduk_ingot"),YWOSDUK_INGOT);
FuelRegistry.INSTANCE.add(YWOSDUK_INGOT, 217);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ywosduk_block"), YWOSDUK_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ywosduk_block"), new BlockItem(YWOSDUK_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ywosduk_ore"), YWOSDUK_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ywosduk_ore"), new BlockItem(YWOSDUK_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_ywosduk"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}