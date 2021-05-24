package fr.anatom3000.gwwhit.materials.suwow;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class SuwowRoot  {
public static final SuwowDust SUWOW_DUST = new SuwowDust();
public static final SuwowBlock SUWOW_BLOCK = new SuwowBlock();
public static final SuwowOre SUWOW_ORE = new SuwowOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","suwow_dust"),SUWOW_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "suwow_block"), SUWOW_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "suwow_block"), new BlockItem(SUWOW_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "suwow_ore"), SUWOW_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "suwow_ore"), new BlockItem(SUWOW_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_suwow"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}