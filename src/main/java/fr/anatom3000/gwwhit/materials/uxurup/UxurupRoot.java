package fr.anatom3000.gwwhit.materials.uxurup;
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
public class UxurupRoot  {
public static final Item UXURUP_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block UXURUP_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.6794135957403693f,2.2701997525637334f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block UXURUP_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5181291584583785f,4.489720722059051f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uxurup_ingot"),UXURUP_INGOT);
FuelRegistry.INSTANCE.add(UXURUP_INGOT, 514);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uxurup_block"), UXURUP_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uxurup_block"), new BlockItem(UXURUP_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uxurup_ore"), UXURUP_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uxurup_ore"), new BlockItem(UXURUP_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uxurup"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}