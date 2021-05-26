package fr.anatom3000.gwwhit.materials.yqubef;
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

public class YqubefRoot  {
public static final Yqubef YQUBEF = new Yqubef();
public static final Block YQUBEF_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.311223746939808f,4.990162821721631f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block YQUBEF_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.2558084941717684f,2.054714714493969f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final YqubefSword YQUBEF_SWORD = new YqubefSword(YqubefMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","yqubef"),YQUBEF);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yqubef_block"), YQUBEF_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yqubef_block"), new BlockItem(YQUBEF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yqubef_ore"), YQUBEF_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yqubef_ore"), new BlockItem(YQUBEF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","yqubef_sword"),YQUBEF_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_yqubef"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}