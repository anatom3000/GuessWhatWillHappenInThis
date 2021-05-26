package fr.anatom3000.gwwhit.materials.ywosduk;
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
public class YwosdukRoot  {
public static final Item YWOSDUK_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block YWOSDUK_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.5623478770931882f,2.664279379455539f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).slipperiness(0.7411951852765625f));
public static final Block YWOSDUK_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.14771438823258f,2.5014601880671057f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","ywosduk_ingot"),YWOSDUK_INGOT);
FuelRegistry.INSTANCE.add(YWOSDUK_INGOT, 217);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ywosduk_block"), YWOSDUK_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ywosduk_block"), new BlockItem(YWOSDUK_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ywosduk_ore"), YWOSDUK_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ywosduk_ore"), new BlockItem(YWOSDUK_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_ywosduk"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}