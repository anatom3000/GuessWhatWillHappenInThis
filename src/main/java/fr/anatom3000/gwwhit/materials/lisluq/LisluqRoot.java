package fr.anatom3000.gwwhit.materials.lisluq;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class LisluqRoot  {
public static final Lisluq LISLUQ = new Lisluq();
public static final LisluqBlock LISLUQ_BLOCK = new LisluqBlock();
public static final LisluqOre LISLUQ_ORE = new LisluqOre();
public static final LisluqShovel LISLUQ_SHOVEL = new LisluqShovel(LisluqMaterial.INSTANCE);
public static final LisluqPickaxe LISLUQ_PICKAXE = new LisluqPickaxe(LisluqMaterial.INSTANCE);
public static final LisluqAxe LISLUQ_AXE = new LisluqAxe(LisluqMaterial.INSTANCE);
public static final LisluqHoe LISLUQ_HOE = new LisluqHoe(LisluqMaterial.INSTANCE);
public static final ArmorMaterial lisluqArmorMaterial = new LisluqArmorMaterial();
public static final LisluqHelmet LISLUQ_HELMET = new LisluqHelmet(lisluqArmorMaterial);
public static final LisluqChestplate LISLUQ_CHESTPLATE = new LisluqChestplate(lisluqArmorMaterial);
public static final LisluqLeggings LISLUQ_LEGGINGS = new LisluqLeggings(lisluqArmorMaterial);
public static final LisluqBoots LISLUQ_BOOTS = new LisluqBoots(lisluqArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq"),LISLUQ);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lisluq_block"), LISLUQ_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_block"), new BlockItem(LISLUQ_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lisluq_ore"), LISLUQ_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_ore"), new BlockItem(LISLUQ_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq_shovel"),LISLUQ_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq_pickaxe"),LISLUQ_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq_axe"),LISLUQ_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq_hoe"),LISLUQ_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq_helmet"),LISLUQ_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq_chestplate"),LISLUQ_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq_leggings"),LISLUQ_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lisluq_boots"),LISLUQ_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_lisluq"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}