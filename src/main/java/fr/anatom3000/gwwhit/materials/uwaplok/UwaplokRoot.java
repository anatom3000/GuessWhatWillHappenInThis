package fr.anatom3000.gwwhit.materials.uwaplok;
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
public class UwaplokRoot  {
public static final Item UWAPLOK = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final UwaplokBlock UWAPLOK_BLOCK = new UwaplokBlock();
public static final Block UWAPLOK_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.6749805451567803f,4.238319247376481f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwaplok"),UWAPLOK);
FuelRegistry.INSTANCE.add(UWAPLOK, 397);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwaplok_block"), UWAPLOK_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwaplok_block"), new BlockItem(UWAPLOK_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwaplok_ore"), UWAPLOK_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwaplok_ore"), new BlockItem(UWAPLOK_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uwaplok"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}