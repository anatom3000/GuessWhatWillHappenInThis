package fr.anatom3000.gwwhit.materials.icawlu;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class IcawluRoot  {
public static final IcawluIngot ICAWLU_INGOT = new IcawluIngot();
public static final IcawluBlock ICAWLU_BLOCK = new IcawluBlock();
public static final IcawluOre ICAWLU_ORE = new IcawluOre();
public static final IcawluShovel ICAWLU_SHOVEL = new IcawluShovel(IcawluMaterial.INSTANCE);
public static final IcawluPickaxe ICAWLU_PICKAXE = new IcawluPickaxe(IcawluMaterial.INSTANCE);
public static final IcawluAxe ICAWLU_AXE = new IcawluAxe(IcawluMaterial.INSTANCE);
public static final IcawluHoe ICAWLU_HOE = new IcawluHoe(IcawluMaterial.INSTANCE);
public static final ArmorMaterial icawluArmorMaterial = new IcawluArmorMaterial();
public static final IcawluHelmet ICAWLU_HELMET = new IcawluHelmet(icawluArmorMaterial);
public static final IcawluChestplate ICAWLU_CHESTPLATE = new IcawluChestplate(icawluArmorMaterial);
public static final IcawluLeggings ICAWLU_LEGGINGS = new IcawluLeggings(icawluArmorMaterial);
public static final IcawluBoots ICAWLU_BOOTS = new IcawluBoots(icawluArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_ingot"),ICAWLU_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "icawlu_block"), ICAWLU_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_block"), new BlockItem(ICAWLU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "icawlu_ore"), ICAWLU_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_ore"), new BlockItem(ICAWLU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_shovel"),ICAWLU_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_pickaxe"),ICAWLU_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_axe"),ICAWLU_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_hoe"),ICAWLU_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_helmet"),ICAWLU_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_chestplate"),ICAWLU_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_leggings"),ICAWLU_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","icawlu_boots"),ICAWLU_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_icawlu"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}