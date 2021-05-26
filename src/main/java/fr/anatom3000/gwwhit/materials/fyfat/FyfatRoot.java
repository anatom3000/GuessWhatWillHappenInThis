package fr.anatom3000.gwwhit.materials.fyfat;
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

public class FyfatRoot  {
public static final Fyfat FYFAT = new Fyfat();
public static final Block FYFAT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.9285772767259357f,1.6451633680577538f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block FYFAT_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.021983156281999f,1.7899523783311384f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.7672129234315004f));
public static final FyfatShovel FYFAT_SHOVEL = new FyfatShovel(FyfatMaterial.INSTANCE);
public static final FyfatPickaxe FYFAT_PICKAXE = new FyfatPickaxe(FyfatMaterial.INSTANCE);
public static final FyfatAxe FYFAT_AXE = new FyfatAxe(FyfatMaterial.INSTANCE);
public static final FyfatHoe FYFAT_HOE = new FyfatHoe(FyfatMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat"),FYFAT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fyfat_block"), FYFAT_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fyfat_block"), new BlockItem(FYFAT_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fyfat_ore"), FYFAT_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fyfat_ore"), new BlockItem(FYFAT_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat_shovel"),FYFAT_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat_pickaxe"),FYFAT_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat_axe"),FYFAT_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat_hoe"),FYFAT_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_fyfat"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}