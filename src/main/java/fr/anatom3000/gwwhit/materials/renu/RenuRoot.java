package fr.anatom3000.gwwhit.materials.renu;
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
public class RenuRoot  {
public static final Item RENU = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block RENU_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.3111354353630866f,2.8778156416473606f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).slipperiness(0.8466700348669063f));
public static final Block RENU_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.4194845704914698f,1.9795404760820334f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final RenuShovel RENU_SHOVEL = new RenuShovel(RenuMaterial.INSTANCE);
public static final RenuPickaxe RENU_PICKAXE = new RenuPickaxe(RenuMaterial.INSTANCE);
public static final RenuAxe RENU_AXE = new RenuAxe(RenuMaterial.INSTANCE);
public static final RenuHoe RENU_HOE = new RenuHoe(RenuMaterial.INSTANCE);
public static final RenuSword RENU_SWORD = new RenuSword(RenuMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu"),RENU);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "renu_block"), RENU_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "renu_block"), new BlockItem(RENU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "renu_ore"), RENU_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "renu_ore"), new BlockItem(RENU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_shovel"),RENU_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_pickaxe"),RENU_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_axe"),RENU_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_hoe"),RENU_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","renu_sword"),RENU_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_renu"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}