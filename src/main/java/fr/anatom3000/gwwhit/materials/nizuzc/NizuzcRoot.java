package fr.anatom3000.gwwhit.materials.nizuzc;
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

import net.minecraft.item.Item;
public class NizuzcRoot  {
public static final Item NIZUZC_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block NIZUZC_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.8451189030996193f,2.7598381979559874f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block NIZUZC_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.3789682704694535f,3.7907699486664597f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final ArmorMaterial nizuzcArmorMaterial = new NizuzcArmorMaterial();
public static final NizuzcHelmet NIZUZC_HELMET = new NizuzcHelmet(nizuzcArmorMaterial);
public static final NizuzcChestplate NIZUZC_CHESTPLATE = new NizuzcChestplate(nizuzcArmorMaterial);
public static final NizuzcLeggings NIZUZC_LEGGINGS = new NizuzcLeggings(nizuzcArmorMaterial);
public static final NizuzcBoots NIZUZC_BOOTS = new NizuzcBoots(nizuzcArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_dust"),NIZUZC_DUST);
FuelRegistry.INSTANCE.add(NIZUZC_DUST, 135);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nizuzc_block"), NIZUZC_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nizuzc_block"), new BlockItem(NIZUZC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nizuzc_ore"), NIZUZC_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nizuzc_ore"), new BlockItem(NIZUZC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_helmet"),NIZUZC_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_chestplate"),NIZUZC_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_leggings"),NIZUZC_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nizuzc_boots"),NIZUZC_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_nizuzc"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}