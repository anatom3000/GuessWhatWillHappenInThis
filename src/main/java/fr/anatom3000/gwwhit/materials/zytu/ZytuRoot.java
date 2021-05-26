package fr.anatom3000.gwwhit.materials.zytu;
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
public class ZytuRoot  {
public static final Item ZYTU_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block ZYTU_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.181319282819409f,2.856104339048716f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block ZYTU_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.7756672377378107f,4.245648694295583f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","zytu_dust"),ZYTU_DUST);
FuelRegistry.INSTANCE.add(ZYTU_DUST, 829);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "zytu_block"), ZYTU_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "zytu_block"), new BlockItem(ZYTU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "zytu_ore"), ZYTU_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "zytu_ore"), new BlockItem(ZYTU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_zytu"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}