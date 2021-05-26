package fr.anatom3000.gwwhit.materials.loded;
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
public class LodedRoot  {
public static final Item LODED = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block LODED_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.3143613274130503f,2.015023086608885f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).slipperiness(0.8402559690947797f));
public static final Block LODED_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.8145814230349977f,1.8744747390428116f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final LodedShovel LODED_SHOVEL = new LodedShovel(LodedMaterial.INSTANCE);
public static final LodedPickaxe LODED_PICKAXE = new LodedPickaxe(LodedMaterial.INSTANCE);
public static final LodedAxe LODED_AXE = new LodedAxe(LodedMaterial.INSTANCE);
public static final LodedHoe LODED_HOE = new LodedHoe(LodedMaterial.INSTANCE);
public static final ArmorMaterial lodedArmorMaterial = new LodedArmorMaterial();
public static final LodedHelmet LODED_HELMET = new LodedHelmet(lodedArmorMaterial);
public static final LodedChestplate LODED_CHESTPLATE = new LodedChestplate(lodedArmorMaterial);
public static final LodedLeggings LODED_LEGGINGS = new LodedLeggings(lodedArmorMaterial);
public static final LodedBoots LODED_BOOTS = new LodedBoots(lodedArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded"),LODED);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "loded_block"), LODED_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "loded_block"), new BlockItem(LODED_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "loded_ore"), LODED_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "loded_ore"), new BlockItem(LODED_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded_shovel"),LODED_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded_pickaxe"),LODED_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded_axe"),LODED_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded_hoe"),LODED_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded_helmet"),LODED_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded_chestplate"),LODED_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded_leggings"),LODED_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","loded_boots"),LODED_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_loded"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}