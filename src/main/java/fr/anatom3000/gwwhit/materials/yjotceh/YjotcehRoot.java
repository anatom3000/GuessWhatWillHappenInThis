package fr.anatom3000.gwwhit.materials.yjotceh;
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
public class YjotcehRoot  {
public static final Item YJOTCEH_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block YJOTCEH_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.7466234188625087f,2.0991076153571644f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block YJOTCEH_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.684605805215211f,2.2255814440263992f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.8298249223988254f));
public static final YjotcehSword YJOTCEH_SWORD = new YjotcehSword(YjotcehMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","yjotceh_ingot"),YJOTCEH_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yjotceh_block"), YJOTCEH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yjotceh_block"), new BlockItem(YJOTCEH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yjotceh_ore"), YJOTCEH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yjotceh_ore"), new BlockItem(YJOTCEH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","yjotceh_sword"),YJOTCEH_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_yjotceh"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}