package fr.anatom3000.gwwhit.materials.luqysk;
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
public class LuqyskRoot  {
public static final Item LUQYSK = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block LUQYSK_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.2179804984444f,2.4804128513426646f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.9952457451652684f));
public static final Block LUQYSK_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.4606853439713725f,3.1933893636656094f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final ArmorMaterial luqyskArmorMaterial = new LuqyskArmorMaterial();
public static final LuqyskHelmet LUQYSK_HELMET = new LuqyskHelmet(luqyskArmorMaterial);
public static final LuqyskChestplate LUQYSK_CHESTPLATE = new LuqyskChestplate(luqyskArmorMaterial);
public static final LuqyskLeggings LUQYSK_LEGGINGS = new LuqyskLeggings(luqyskArmorMaterial);
public static final LuqyskBoots LUQYSK_BOOTS = new LuqyskBoots(luqyskArmorMaterial);
public static final LuqyskSword LUQYSK_SWORD = new LuqyskSword(LuqyskMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk"),LUQYSK);
FuelRegistry.INSTANCE.add(LUQYSK, 117);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "luqysk_block"), LUQYSK_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "luqysk_block"), new BlockItem(LUQYSK_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "luqysk_ore"), LUQYSK_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "luqysk_ore"), new BlockItem(LUQYSK_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_helmet"),LUQYSK_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_chestplate"),LUQYSK_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_leggings"),LUQYSK_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_boots"),LUQYSK_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","luqysk_sword"),LUQYSK_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_luqysk"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}