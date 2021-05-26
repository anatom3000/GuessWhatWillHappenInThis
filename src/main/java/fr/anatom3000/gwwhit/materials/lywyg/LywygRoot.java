package fr.anatom3000.gwwhit.materials.lywyg;

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
public class LywygRoot  {
public static final Lywyg LYWYG = new Lywyg();
public static final LywygBlock LYWYG_BLOCK = new LywygBlock();
public static final LywygOre LYWYG_ORE = new LywygOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","lywyg"),LYWYG);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lywyg_block"), LYWYG_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lywyg_block"), new BlockItem(LYWYG_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lywyg_ore"), LYWYG_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lywyg_ore"), new BlockItem(LYWYG_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_lywyg"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}