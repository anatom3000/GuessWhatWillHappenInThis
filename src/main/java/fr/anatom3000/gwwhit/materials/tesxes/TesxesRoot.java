package fr.anatom3000.gwwhit.materials.tesxes;

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
public class TesxesRoot  {
public static final Tesxes TESXES = new Tesxes();
public static final TesxesBlock TESXES_BLOCK = new TesxesBlock();
public static final TesxesOre TESXES_ORE = new TesxesOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","tesxes"),TESXES);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tesxes_block"), TESXES_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tesxes_block"), new BlockItem(TESXES_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tesxes_ore"), TESXES_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tesxes_ore"), new BlockItem(TESXES_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_tesxes"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}