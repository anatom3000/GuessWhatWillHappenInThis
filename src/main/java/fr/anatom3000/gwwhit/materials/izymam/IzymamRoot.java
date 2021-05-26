package fr.anatom3000.gwwhit.materials.izymam;
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

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class IzymamRoot  {
public static final IzymamIngot IZYMAM_INGOT = new IzymamIngot();
public static final Block IZYMAM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.279469982202987f,1.0907666269647844f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block IZYMAM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.73278793933846f,1.0817060508805998f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final IzymamShovel IZYMAM_SHOVEL = new IzymamShovel(IzymamMaterial.INSTANCE);
public static final IzymamPickaxe IZYMAM_PICKAXE = new IzymamPickaxe(IzymamMaterial.INSTANCE);
public static final IzymamAxe IZYMAM_AXE = new IzymamAxe(IzymamMaterial.INSTANCE);
public static final IzymamHoe IZYMAM_HOE = new IzymamHoe(IzymamMaterial.INSTANCE);
public static final ArmorMaterial izymamArmorMaterial = new IzymamArmorMaterial();
public static final IzymamHelmet IZYMAM_HELMET = new IzymamHelmet(izymamArmorMaterial);
public static final IzymamChestplate IZYMAM_CHESTPLATE = new IzymamChestplate(izymamArmorMaterial);
public static final IzymamLeggings IZYMAM_LEGGINGS = new IzymamLeggings(izymamArmorMaterial);
public static final IzymamBoots IZYMAM_BOOTS = new IzymamBoots(izymamArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_ingot"),IZYMAM_INGOT);
FuelRegistry.INSTANCE.add(IZYMAM_INGOT, 160);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "izymam_block"), IZYMAM_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "izymam_block"), new BlockItem(IZYMAM_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "izymam_ore"), IZYMAM_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "izymam_ore"), new BlockItem(IZYMAM_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_shovel"),IZYMAM_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_pickaxe"),IZYMAM_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_axe"),IZYMAM_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_hoe"),IZYMAM_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_helmet"),IZYMAM_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_chestplate"),IZYMAM_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_leggings"),IZYMAM_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","izymam_boots"),IZYMAM_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_izymam"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}