package fr.anatom3000.gwwhit.materials.xugaw;

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
public class XugawRoot  {
public static final Xugaw XUGAW = new Xugaw();
public static final XugawBlock XUGAW_BLOCK = new XugawBlock();
public static final XugawOre XUGAW_ORE = new XugawOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","xugaw"),XUGAW);
FuelRegistry.INSTANCE.add(XUGAW, 635);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "xugaw_block"), XUGAW_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "xugaw_block"), new BlockItem(XUGAW_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "xugaw_ore"), XUGAW_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "xugaw_ore"), new BlockItem(XUGAW_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_xugaw"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}