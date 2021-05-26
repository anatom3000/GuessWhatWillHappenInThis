package fr.anatom3000.gwwhit.materials.tugo;
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

public class TugoRoot  {
public static final Tugo TUGO = new Tugo();
public static final Block TUGO_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.200979108884199f,2.039312289399117f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block TUGO_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.1213986174379613f,2.0118248104123397f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final TugoShovel TUGO_SHOVEL = new TugoShovel(TugoMaterial.INSTANCE);
public static final TugoPickaxe TUGO_PICKAXE = new TugoPickaxe(TugoMaterial.INSTANCE);
public static final TugoAxe TUGO_AXE = new TugoAxe(TugoMaterial.INSTANCE);
public static final TugoHoe TUGO_HOE = new TugoHoe(TugoMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","tugo"),TUGO);
FuelRegistry.INSTANCE.add(TUGO, 718);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tugo_block"), TUGO_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tugo_block"), new BlockItem(TUGO_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tugo_ore"), TUGO_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tugo_ore"), new BlockItem(TUGO_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","tugo_shovel"),TUGO_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","tugo_pickaxe"),TUGO_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","tugo_axe"),TUGO_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","tugo_hoe"),TUGO_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_tugo"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}