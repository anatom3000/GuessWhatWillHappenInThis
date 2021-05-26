package fr.anatom3000.gwwhit.materials.asymcof;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
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
public class AsymcofRoot  {
public static final Item ASYMCOF_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block ASYMCOF_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.2041225327542704f,3.6898874468318734f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block ASYMCOF_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.2811016371460808f,2.154640712175668f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).luminance(7));
public static final AsymcofShovel ASYMCOF_SHOVEL = new AsymcofShovel(AsymcofMaterial.INSTANCE);
public static final AsymcofPickaxe ASYMCOF_PICKAXE = new AsymcofPickaxe(AsymcofMaterial.INSTANCE);
public static final AsymcofAxe ASYMCOF_AXE = new AsymcofAxe(AsymcofMaterial.INSTANCE);
public static final AsymcofHoe ASYMCOF_HOE = new AsymcofHoe(AsymcofMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_ingot"),ASYMCOF_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "asymcof_block"), ASYMCOF_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "asymcof_block"), new BlockItem(ASYMCOF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "asymcof_ore"), ASYMCOF_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "asymcof_ore"), new BlockItem(ASYMCOF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_shovel"),ASYMCOF_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_pickaxe"),ASYMCOF_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_axe"),ASYMCOF_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","asymcof_hoe"),ASYMCOF_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_asymcof"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}