package fr.anatom3000.gwwhit.materials.fucox;
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
public class FucoxRoot  {
public static final Item FUCOX_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block FUCOX_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.058751377033673f,4.809084437011796f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block FUCOX_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.2476019435773864f,2.6980823120057074f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final FucoxShovel FUCOX_SHOVEL = new FucoxShovel(FucoxMaterial.INSTANCE);
public static final FucoxPickaxe FUCOX_PICKAXE = new FucoxPickaxe(FucoxMaterial.INSTANCE);
public static final FucoxAxe FUCOX_AXE = new FucoxAxe(FucoxMaterial.INSTANCE);
public static final FucoxHoe FUCOX_HOE = new FucoxHoe(FucoxMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_dust"),FUCOX_DUST);
FuelRegistry.INSTANCE.add(FUCOX_DUST, 897);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fucox_block"), FUCOX_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fucox_block"), new BlockItem(FUCOX_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fucox_ore"), FUCOX_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fucox_ore"), new BlockItem(FUCOX_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_shovel"),FUCOX_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_pickaxe"),FUCOX_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_axe"),FUCOX_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fucox_hoe"),FUCOX_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_fucox"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}