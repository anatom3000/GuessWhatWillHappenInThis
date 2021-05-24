package fr.anatom3000.gwwhit.materials.tetus;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class TetusRoot  {
public static final Tetus TETUS = new Tetus();
public static final TetusBlock TETUS_BLOCK = new TetusBlock();
public static final TetusOre TETUS_ORE = new TetusOre();
public static final TetusSword TETUS_SWORD = new TetusSword(TetusMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","tetus"),TETUS);
FuelRegistry.INSTANCE.add(TETUS, 576);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tetus_block"), TETUS_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tetus_block"), new BlockItem(TETUS_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tetus_ore"), TETUS_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tetus_ore"), new BlockItem(TETUS_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","tetus_sword"),TETUS_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_tetus"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}