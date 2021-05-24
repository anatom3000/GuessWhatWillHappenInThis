package fr.anatom3000.gwwhit.materials.otakag;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class OtakagRoot  {
public static final OtakagIngot OTAKAG_INGOT = new OtakagIngot();
public static final OtakagBlock OTAKAG_BLOCK = new OtakagBlock();
public static final OtakagOre OTAKAG_ORE = new OtakagOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","otakag_ingot"),OTAKAG_INGOT);
FuelRegistry.INSTANCE.add(OTAKAG_INGOT, 885);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "otakag_block"), OTAKAG_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "otakag_block"), new BlockItem(OTAKAG_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "otakag_ore"), OTAKAG_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "otakag_ore"), new BlockItem(OTAKAG_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_otakag"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}