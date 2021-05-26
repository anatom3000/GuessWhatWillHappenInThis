package fr.anatom3000.gwwhit.materials.aqyqyf;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import net.minecraft.item.Item;
public class AqyqyfRoot  {
public static final Item AQYQYF_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block AQYQYF_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.714998321129406f,3.402009140837683f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block AQYQYF_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5719358374057593f,4.335500428922923f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final AqyqyfShovel AQYQYF_SHOVEL = new AqyqyfShovel(AqyqyfMaterial.INSTANCE);
public static final AqyqyfPickaxe AQYQYF_PICKAXE = new AqyqyfPickaxe(AqyqyfMaterial.INSTANCE);
public static final AqyqyfAxe AQYQYF_AXE = new AqyqyfAxe(AqyqyfMaterial.INSTANCE);
public static final AqyqyfHoe AQYQYF_HOE = new AqyqyfHoe(AqyqyfMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_ingot"),AQYQYF_INGOT);
FuelRegistry.INSTANCE.add(AQYQYF_INGOT, 687);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "aqyqyf_block"), AQYQYF_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "aqyqyf_block"), new BlockItem(AQYQYF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "aqyqyf_ore"), AQYQYF_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "aqyqyf_ore"), new BlockItem(AQYQYF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_shovel"),AQYQYF_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_pickaxe"),AQYQYF_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_axe"),AQYQYF_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","aqyqyf_hoe"),AQYQYF_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_aqyqyf"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}