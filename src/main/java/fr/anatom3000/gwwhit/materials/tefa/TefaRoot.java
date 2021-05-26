package fr.anatom3000.gwwhit.materials.tefa;
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
public class TefaRoot  {
public static final Item TEFA_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block TEFA_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.081838582236901f,3.0932909786732807f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block TEFA_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.6420650822213894f,1.56302812285616f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final TefaSword TEFA_SWORD = new TefaSword(TefaMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","tefa_dust"),TEFA_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tefa_block"), TEFA_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tefa_block"), new BlockItem(TEFA_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tefa_ore"), TEFA_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tefa_ore"), new BlockItem(TEFA_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","tefa_sword"),TEFA_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_tefa"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}