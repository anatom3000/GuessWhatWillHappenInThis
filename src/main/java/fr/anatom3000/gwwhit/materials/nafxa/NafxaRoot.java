package fr.anatom3000.gwwhit.materials.nafxa;
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
public class NafxaRoot  {
public static final Item NAFXA_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block NAFXA_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.748258534596772f,4.567033414822431f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block NAFXA_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.4237191032727528f,1.6917404711542843f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final NafxaShovel NAFXA_SHOVEL = new NafxaShovel(NafxaMaterial.INSTANCE);
public static final NafxaPickaxe NAFXA_PICKAXE = new NafxaPickaxe(NafxaMaterial.INSTANCE);
public static final NafxaAxe NAFXA_AXE = new NafxaAxe(NafxaMaterial.INSTANCE);
public static final NafxaHoe NAFXA_HOE = new NafxaHoe(NafxaMaterial.INSTANCE);
public static final ArmorMaterial nafxaArmorMaterial = new NafxaArmorMaterial();
public static final NafxaHelmet NAFXA_HELMET = new NafxaHelmet(nafxaArmorMaterial);
public static final NafxaChestplate NAFXA_CHESTPLATE = new NafxaChestplate(nafxaArmorMaterial);
public static final NafxaLeggings NAFXA_LEGGINGS = new NafxaLeggings(nafxaArmorMaterial);
public static final NafxaBoots NAFXA_BOOTS = new NafxaBoots(nafxaArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_dust"),NAFXA_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nafxa_block"), NAFXA_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nafxa_block"), new BlockItem(NAFXA_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nafxa_ore"), NAFXA_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nafxa_ore"), new BlockItem(NAFXA_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_shovel"),NAFXA_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_pickaxe"),NAFXA_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_axe"),NAFXA_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_hoe"),NAFXA_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_helmet"),NAFXA_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_chestplate"),NAFXA_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_leggings"),NAFXA_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nafxa_boots"),NAFXA_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_nafxa"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}