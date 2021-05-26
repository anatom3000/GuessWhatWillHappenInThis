package fr.anatom3000.gwwhit.materials.ohyxfu;
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

public class OhyxfuRoot  {
public static final OhyxfuIngot OHYXFU_INGOT = new OhyxfuIngot();
public static final Block OHYXFU_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.934614329831127f,4.387169677866746f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block OHYXFU_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5797628151701555f,1.7304155122687859f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final OhyxfuSword OHYXFU_SWORD = new OhyxfuSword(OhyxfuMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","ohyxfu_ingot"),OHYXFU_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ohyxfu_block"), OHYXFU_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ohyxfu_block"), new BlockItem(OHYXFU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ohyxfu_ore"), OHYXFU_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ohyxfu_ore"), new BlockItem(OHYXFU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","ohyxfu_sword"),OHYXFU_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_ohyxfu"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}