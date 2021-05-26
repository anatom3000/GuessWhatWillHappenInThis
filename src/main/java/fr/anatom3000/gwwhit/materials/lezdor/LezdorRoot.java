package fr.anatom3000.gwwhit.materials.lezdor;
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
public class LezdorRoot  {
public static final Item LEZDOR_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block LEZDOR_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.855320847752626f,3.466843311687021f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block LEZDOR_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.472960557070697f,1.422640976883577f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).luminance(2));
public static final ArmorMaterial lezdorArmorMaterial = new LezdorArmorMaterial();
public static final LezdorHelmet LEZDOR_HELMET = new LezdorHelmet(lezdorArmorMaterial);
public static final LezdorChestplate LEZDOR_CHESTPLATE = new LezdorChestplate(lezdorArmorMaterial);
public static final LezdorLeggings LEZDOR_LEGGINGS = new LezdorLeggings(lezdorArmorMaterial);
public static final LezdorBoots LEZDOR_BOOTS = new LezdorBoots(lezdorArmorMaterial);
public static final LezdorSword LEZDOR_SWORD = new LezdorSword(LezdorMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_dust"),LEZDOR_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lezdor_block"), LEZDOR_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lezdor_block"), new BlockItem(LEZDOR_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lezdor_ore"), LEZDOR_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lezdor_ore"), new BlockItem(LEZDOR_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_helmet"),LEZDOR_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_chestplate"),LEZDOR_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_leggings"),LEZDOR_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_boots"),LEZDOR_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","lezdor_sword"),LEZDOR_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_lezdor"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}