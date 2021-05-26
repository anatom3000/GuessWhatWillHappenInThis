package fr.anatom3000.gwwhit.materials.uwalusq;
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

public class UwalusqRoot  {
public static final UwalusqIngot UWALUSQ_INGOT = new UwalusqIngot();
public static final Block UWALUSQ_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.3473145044352015f,2.891956251751754f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block UWALUSQ_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.377612215255365f,4.642682211595366f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final UwalusqShovel UWALUSQ_SHOVEL = new UwalusqShovel(UwalusqMaterial.INSTANCE);
public static final UwalusqPickaxe UWALUSQ_PICKAXE = new UwalusqPickaxe(UwalusqMaterial.INSTANCE);
public static final UwalusqAxe UWALUSQ_AXE = new UwalusqAxe(UwalusqMaterial.INSTANCE);
public static final UwalusqHoe UWALUSQ_HOE = new UwalusqHoe(UwalusqMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_ingot"),UWALUSQ_INGOT);
FuelRegistry.INSTANCE.add(UWALUSQ_INGOT, 171);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwalusq_block"), UWALUSQ_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwalusq_block"), new BlockItem(UWALUSQ_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwalusq_ore"), UWALUSQ_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwalusq_ore"), new BlockItem(UWALUSQ_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_shovel"),UWALUSQ_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_pickaxe"),UWALUSQ_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_axe"),UWALUSQ_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uwalusq_hoe"),UWALUSQ_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uwalusq"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}