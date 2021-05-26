package fr.anatom3000.gwwhit.materials.baqi;
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
public class BaqiRoot  {
public static final Item BAQI_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block BAQI_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.0996065524420806f,2.098160719689327f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block BAQI_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.7430235826234375f,1.10769685313067f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final BaqiShovel BAQI_SHOVEL = new BaqiShovel(BaqiMaterial.INSTANCE);
public static final BaqiPickaxe BAQI_PICKAXE = new BaqiPickaxe(BaqiMaterial.INSTANCE);
public static final BaqiAxe BAQI_AXE = new BaqiAxe(BaqiMaterial.INSTANCE);
public static final BaqiHoe BAQI_HOE = new BaqiHoe(BaqiMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_dust"),BAQI_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "baqi_block"), BAQI_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "baqi_block"), new BlockItem(BAQI_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "baqi_ore"), BAQI_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "baqi_ore"), new BlockItem(BAQI_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_shovel"),BAQI_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_pickaxe"),BAQI_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_axe"),BAQI_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","baqi_hoe"),BAQI_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_baqi"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}