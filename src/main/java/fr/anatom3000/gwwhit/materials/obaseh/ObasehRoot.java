package fr.anatom3000.gwwhit.materials.obaseh;
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
public class ObasehRoot  {
public static final Item OBASEH_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block OBASEH_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.9844008373383866f,3.8564149777732926f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block OBASEH_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.43085804245456f,2.0314685723113426f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final ObasehShovel OBASEH_SHOVEL = new ObasehShovel(ObasehMaterial.INSTANCE);
public static final ObasehPickaxe OBASEH_PICKAXE = new ObasehPickaxe(ObasehMaterial.INSTANCE);
public static final ObasehAxe OBASEH_AXE = new ObasehAxe(ObasehMaterial.INSTANCE);
public static final ObasehHoe OBASEH_HOE = new ObasehHoe(ObasehMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_ingot"),OBASEH_INGOT);
FuelRegistry.INSTANCE.add(OBASEH_INGOT, 113);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "obaseh_block"), OBASEH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "obaseh_block"), new BlockItem(OBASEH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "obaseh_ore"), OBASEH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "obaseh_ore"), new BlockItem(OBASEH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_shovel"),OBASEH_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_pickaxe"),OBASEH_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_axe"),OBASEH_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_hoe"),OBASEH_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_obaseh"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}