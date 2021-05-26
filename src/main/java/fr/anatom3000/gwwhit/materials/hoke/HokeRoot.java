package fr.anatom3000.gwwhit.materials.hoke;
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
public class HokeRoot  {
public static final Item HOKE_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final HokeBlock HOKE_BLOCK = new HokeBlock();
public static final Block HOKE_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.327095668626132f,2.7601037906941257f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.7664829949827581f));
public static final HokeSword HOKE_SWORD = new HokeSword(HokeMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","hoke_dust"),HOKE_DUST);
FuelRegistry.INSTANCE.add(HOKE_DUST, 515);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "hoke_block"), HOKE_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "hoke_block"), new BlockItem(HOKE_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "hoke_ore"), HOKE_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "hoke_ore"), new BlockItem(HOKE_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","hoke_sword"),HOKE_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_hoke"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}