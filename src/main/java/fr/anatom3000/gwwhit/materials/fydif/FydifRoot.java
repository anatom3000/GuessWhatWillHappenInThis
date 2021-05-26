package fr.anatom3000.gwwhit.materials.fydif;
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
public class FydifRoot  {
public static final Item FYDIF = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block FYDIF_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.3060341567094085f,2.6318259882365216f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block FYDIF_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.6749089205557137f,2.8845978699148587f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final FydifShovel FYDIF_SHOVEL = new FydifShovel(FydifMaterial.INSTANCE);
public static final FydifPickaxe FYDIF_PICKAXE = new FydifPickaxe(FydifMaterial.INSTANCE);
public static final FydifAxe FYDIF_AXE = new FydifAxe(FydifMaterial.INSTANCE);
public static final FydifHoe FYDIF_HOE = new FydifHoe(FydifMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","fydif"),FYDIF);
FuelRegistry.INSTANCE.add(FYDIF, 766);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fydif_block"), FYDIF_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fydif_block"), new BlockItem(FYDIF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fydif_ore"), FYDIF_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fydif_ore"), new BlockItem(FYDIF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","fydif_shovel"),FYDIF_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fydif_pickaxe"),FYDIF_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fydif_axe"),FYDIF_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fydif_hoe"),FYDIF_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_fydif"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}