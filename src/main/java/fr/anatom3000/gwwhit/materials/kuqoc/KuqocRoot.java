package fr.anatom3000.gwwhit.materials.kuqoc;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class KuqocRoot  {
public static final KuqocDust KUQOC_DUST = new KuqocDust();
public static final KuqocBlock KUQOC_BLOCK = new KuqocBlock();
public static final KuqocOre KUQOC_ORE = new KuqocOre();
public static final KuqocSword KUQOC_SWORD = new KuqocSword(KuqocMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","kuqoc_dust"),KUQOC_DUST);
FuelRegistry.INSTANCE.add(KUQOC_DUST, 381);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "kuqoc_block"), KUQOC_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "kuqoc_block"), new BlockItem(KUQOC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "kuqoc_ore"), KUQOC_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "kuqoc_ore"), new BlockItem(KUQOC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","kuqoc_sword"),KUQOC_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_kuqoc"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}