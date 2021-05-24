package fr.anatom3000.gwwhit.materials.asymcof;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class AsymcofRoot  {
public static final AsymcofIngot ASYMCOF_INGOT = new AsymcofIngot();
public static final AsymcofBlock ASYMCOF_BLOCK = new AsymcofBlock();
public static final AsymcofOre ASYMCOF_ORE = new AsymcofOre();
public static final AsymcofShovel ASYMCOF_SHOVEL = new AsymcofShovel(AsymcofMaterial.INSTANCE);
public static final AsymcofPickaxe ASYMCOF_PICKAXE = new AsymcofPickaxe(AsymcofMaterial.INSTANCE);
public static final AsymcofAxe ASYMCOF_AXE = new AsymcofAxe(AsymcofMaterial.INSTANCE);
public static final AsymcofHoe ASYMCOF_HOE = new AsymcofHoe(AsymcofMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_ingot"),ASYMCOF_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "asymcof_block"), ASYMCOF_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "asymcof_block"), new BlockItem(ASYMCOF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "asymcof_ore"), ASYMCOF_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "asymcof_ore"), new BlockItem(ASYMCOF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_shovel"),ASYMCOF_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_pickaxe"),ASYMCOF_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_axe"),ASYMCOF_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_hoe"),ASYMCOF_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_asymcof"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}