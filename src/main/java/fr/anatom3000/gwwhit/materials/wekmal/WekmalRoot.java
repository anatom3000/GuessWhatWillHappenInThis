package fr.anatom3000.gwwhit.materials.wekmal;
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

public class WekmalRoot  {
public static final WekmalDust WEKMAL_DUST = new WekmalDust();
public static final Block WEKMAL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.626049772608876f,4.792349075006154f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block WEKMAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0999565424338655f,2.2627085630941344f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final WekmalShovel WEKMAL_SHOVEL = new WekmalShovel(WekmalMaterial.INSTANCE);
public static final WekmalPickaxe WEKMAL_PICKAXE = new WekmalPickaxe(WekmalMaterial.INSTANCE);
public static final WekmalAxe WEKMAL_AXE = new WekmalAxe(WekmalMaterial.INSTANCE);
public static final WekmalHoe WEKMAL_HOE = new WekmalHoe(WekmalMaterial.INSTANCE);
public static final WekmalSword WEKMAL_SWORD = new WekmalSword(WekmalMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","wekmal_dust"),WEKMAL_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "wekmal_block"), WEKMAL_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "wekmal_block"), new BlockItem(WEKMAL_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "wekmal_ore"), WEKMAL_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "wekmal_ore"), new BlockItem(WEKMAL_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","wekmal_shovel"),WEKMAL_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wekmal_pickaxe"),WEKMAL_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wekmal_axe"),WEKMAL_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wekmal_hoe"),WEKMAL_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wekmal_sword"),WEKMAL_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_wekmal"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}