package fr.anatom3000.gwwhit.materials.umaboz;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class UmabozRoot  {
public static final UmabozIngot UMABOZ_INGOT = new UmabozIngot();
public static final UmabozBlock UMABOZ_BLOCK = new UmabozBlock();
public static final UmabozOre UMABOZ_ORE = new UmabozOre();
public static final UmabozShovel UMABOZ_SHOVEL = new UmabozShovel(UmabozMaterial.INSTANCE);
public static final UmabozPickaxe UMABOZ_PICKAXE = new UmabozPickaxe(UmabozMaterial.INSTANCE);
public static final UmabozAxe UMABOZ_AXE = new UmabozAxe(UmabozMaterial.INSTANCE);
public static final UmabozHoe UMABOZ_HOE = new UmabozHoe(UmabozMaterial.INSTANCE);
public static final ArmorMaterial umabozArmorMaterial = new UmabozArmorMaterial();
public static final UmabozHelmet UMABOZ_HELMET = new UmabozHelmet(umabozArmorMaterial);
public static final UmabozChestplate UMABOZ_CHESTPLATE = new UmabozChestplate(umabozArmorMaterial);
public static final UmabozLeggings UMABOZ_LEGGINGS = new UmabozLeggings(umabozArmorMaterial);
public static final UmabozBoots UMABOZ_BOOTS = new UmabozBoots(umabozArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_ingot"),UMABOZ_INGOT);
FuelRegistry.INSTANCE.add(UMABOZ_INGOT, 745);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "umaboz_block"), UMABOZ_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "umaboz_block"), new BlockItem(UMABOZ_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "umaboz_ore"), UMABOZ_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "umaboz_ore"), new BlockItem(UMABOZ_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_shovel"),UMABOZ_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_pickaxe"),UMABOZ_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_axe"),UMABOZ_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_hoe"),UMABOZ_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_helmet"),UMABOZ_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_chestplate"),UMABOZ_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_leggings"),UMABOZ_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","umaboz_boots"),UMABOZ_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_umaboz"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}