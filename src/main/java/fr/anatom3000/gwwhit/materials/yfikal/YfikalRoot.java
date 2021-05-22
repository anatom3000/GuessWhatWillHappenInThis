package fr.anatom3000.gwwhit.materials.yfikal;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class YfikalRoot  {
public static final YfikalIngot YFIKAL_INGOT = new YfikalIngot();
public static final YfikalBlock YFIKAL_BLOCK = new YfikalBlock();
public static final YfikalOre YFIKAL_ORE = new YfikalOre();
public static final YfikalShovel YFIKAL_SHOVEL = new YfikalShovel(YfikalMaterial.INSTANCE);
public static final YfikalPickaxe YFIKAL_PICKAXE = new YfikalPickaxe(YfikalMaterial.INSTANCE);
public static final YfikalAxe YFIKAL_AXE = new YfikalAxe(YfikalMaterial.INSTANCE);
public static final YfikalHoe YFIKAL_HOE = new YfikalHoe(YfikalMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","yfikal_ingot"),YFIKAL_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yfikal_block"), YFIKAL_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yfikal_block"), new BlockItem(YFIKAL_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yfikal_ore"), YFIKAL_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yfikal_ore"), new BlockItem(YFIKAL_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","yfikal_shovel"),YFIKAL_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","yfikal_pickaxe"),YFIKAL_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","yfikal_axe"),YFIKAL_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","yfikal_hoe"),YFIKAL_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_yfikal"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}