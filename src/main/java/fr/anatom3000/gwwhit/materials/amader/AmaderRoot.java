package fr.anatom3000.gwwhit.materials.amader;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
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

import net.minecraft.item.Item;
public class AmaderRoot  {
public static final Item AMADER_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block AMADER_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.0325704501380644f,3.013930612738863f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block AMADER_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.505565659243803f,1.0655254386080033f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final AmaderShovel AMADER_SHOVEL = new AmaderShovel(AmaderMaterial.INSTANCE);
public static final AmaderPickaxe AMADER_PICKAXE = new AmaderPickaxe(AmaderMaterial.INSTANCE);
public static final AmaderAxe AMADER_AXE = new AmaderAxe(AmaderMaterial.INSTANCE);
public static final AmaderHoe AMADER_HOE = new AmaderHoe(AmaderMaterial.INSTANCE);
public static final ArmorMaterial amaderArmorMaterial = new AmaderArmorMaterial();
public static final AmaderHelmet AMADER_HELMET = new AmaderHelmet(amaderArmorMaterial);
public static final AmaderChestplate AMADER_CHESTPLATE = new AmaderChestplate(amaderArmorMaterial);
public static final AmaderLeggings AMADER_LEGGINGS = new AmaderLeggings(amaderArmorMaterial);
public static final AmaderBoots AMADER_BOOTS = new AmaderBoots(amaderArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_ingot"),AMADER_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "amader_block"), AMADER_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "amader_block"), new BlockItem(AMADER_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "amader_ore"), AMADER_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "amader_ore"), new BlockItem(AMADER_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_shovel"),AMADER_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_pickaxe"),AMADER_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_axe"),AMADER_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_hoe"),AMADER_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_helmet"),AMADER_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_chestplate"),AMADER_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_leggings"),AMADER_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","amader_boots"),AMADER_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_amader"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}