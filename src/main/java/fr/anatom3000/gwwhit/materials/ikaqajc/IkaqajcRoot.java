package fr.anatom3000.gwwhit.materials.ikaqajc;
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
public class IkaqajcRoot  {
public static final Item IKAQAJC = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block IKAQAJC_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.31886082293468f,1.407981946078615f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block IKAQAJC_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.018616076545011f,1.9324388800180428f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final ArmorMaterial ikaqajcArmorMaterial = new IkaqajcArmorMaterial();
public static final IkaqajcHelmet IKAQAJC_HELMET = new IkaqajcHelmet(ikaqajcArmorMaterial);
public static final IkaqajcChestplate IKAQAJC_CHESTPLATE = new IkaqajcChestplate(ikaqajcArmorMaterial);
public static final IkaqajcLeggings IKAQAJC_LEGGINGS = new IkaqajcLeggings(ikaqajcArmorMaterial);
public static final IkaqajcBoots IKAQAJC_BOOTS = new IkaqajcBoots(ikaqajcArmorMaterial);
public static final IkaqajcSword IKAQAJC_SWORD = new IkaqajcSword(IkaqajcMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","ikaqajc"),IKAQAJC);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ikaqajc_block"), IKAQAJC_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ikaqajc_block"), new BlockItem(IKAQAJC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ikaqajc_ore"), IKAQAJC_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ikaqajc_ore"), new BlockItem(IKAQAJC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","ikaqajc_helmet"),IKAQAJC_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ikaqajc_chestplate"),IKAQAJC_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ikaqajc_leggings"),IKAQAJC_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ikaqajc_boots"),IKAQAJC_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ikaqajc_sword"),IKAQAJC_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_ikaqajc"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}