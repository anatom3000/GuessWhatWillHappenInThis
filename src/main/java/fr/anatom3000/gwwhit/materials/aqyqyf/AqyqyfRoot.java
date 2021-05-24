package fr.anatom3000.gwwhit.materials.aqyqyf;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class AqyqyfRoot  {
public static final AqyqyfIngot AQYQYF_INGOT = new AqyqyfIngot();
public static final AqyqyfBlock AQYQYF_BLOCK = new AqyqyfBlock();
public static final AqyqyfOre AQYQYF_ORE = new AqyqyfOre();
public static final AqyqyfShovel AQYQYF_SHOVEL = new AqyqyfShovel(AqyqyfMaterial.INSTANCE);
public static final AqyqyfPickaxe AQYQYF_PICKAXE = new AqyqyfPickaxe(AqyqyfMaterial.INSTANCE);
public static final AqyqyfAxe AQYQYF_AXE = new AqyqyfAxe(AqyqyfMaterial.INSTANCE);
public static final AqyqyfHoe AQYQYF_HOE = new AqyqyfHoe(AqyqyfMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_ingot"),AQYQYF_INGOT);
FuelRegistry.INSTANCE.add(AQYQYF_INGOT, 687);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "aqyqyf_block"), AQYQYF_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "aqyqyf_block"), new BlockItem(AQYQYF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "aqyqyf_ore"), AQYQYF_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "aqyqyf_ore"), new BlockItem(AQYQYF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_shovel"),AQYQYF_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_pickaxe"),AQYQYF_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_axe"),AQYQYF_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_hoe"),AQYQYF_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_aqyqyf"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}