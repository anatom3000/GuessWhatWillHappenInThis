package fr.anatom3000.gwwhit.materials.otakag;
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
public class OtakagRoot  {
public static final Item OTAKAG_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block OTAKAG_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.7011058362365903f,1.403393897078998f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block OTAKAG_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.556025044681982f,4.327806248506748f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","otakag_ingot"),OTAKAG_INGOT);
FuelRegistry.INSTANCE.add(OTAKAG_INGOT, 885);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "otakag_block"), OTAKAG_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "otakag_block"), new BlockItem(OTAKAG_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "otakag_ore"), OTAKAG_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "otakag_ore"), new BlockItem(OTAKAG_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_otakag"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}