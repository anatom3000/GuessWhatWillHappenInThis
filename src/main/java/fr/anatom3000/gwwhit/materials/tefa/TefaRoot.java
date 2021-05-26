package fr.anatom3000.gwwhit.materials.tefa;

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
public class TefaRoot  {
public static final TefaDust TEFA_DUST = new TefaDust();
public static final TefaBlock TEFA_BLOCK = new TefaBlock();
public static final TefaOre TEFA_ORE = new TefaOre();
public static final TefaSword TEFA_SWORD = new TefaSword(TefaMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","tefa_dust"),TEFA_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tefa_block"), TEFA_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tefa_block"), new BlockItem(TEFA_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tefa_ore"), TEFA_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tefa_ore"), new BlockItem(TEFA_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","tefa_sword"),TEFA_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_tefa"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}