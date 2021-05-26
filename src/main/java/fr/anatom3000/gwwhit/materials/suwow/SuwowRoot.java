package fr.anatom3000.gwwhit.materials.suwow;
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
public class SuwowRoot  {
public static final Item SUWOW_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block SUWOW_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.1801718777884025f,3.635981503342259f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block SUWOW_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5441362138762518f,4.334463911378237f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","suwow_dust"),SUWOW_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "suwow_block"), SUWOW_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "suwow_block"), new BlockItem(SUWOW_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "suwow_ore"), SUWOW_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "suwow_ore"), new BlockItem(SUWOW_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_suwow"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}