package fr.anatom3000.gwwhit.materials.hugom;
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
public class HugomRoot  {
public static final Item HUGOM_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block HUGOM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.898667262197131f,3.7385198932044745f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block HUGOM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.831169711630695f,1.1322997320594994f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final HugomSword HUGOM_SWORD = new HugomSword(HugomMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","hugom_dust"),HUGOM_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "hugom_block"), HUGOM_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "hugom_block"), new BlockItem(HUGOM_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "hugom_ore"), HUGOM_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "hugom_ore"), new BlockItem(HUGOM_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","hugom_sword"),HUGOM_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_hugom"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}