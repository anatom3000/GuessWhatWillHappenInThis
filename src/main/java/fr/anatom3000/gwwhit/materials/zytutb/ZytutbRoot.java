package fr.anatom3000.gwwhit.materials.zytutb;
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

public class ZytutbRoot  {
public static final ZytutbDust ZYTUTB_DUST = new ZytutbDust();
public static final ZytutbBlock ZYTUTB_BLOCK = new ZytutbBlock();
public static final Block ZYTUTB_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.7796033242652385f,4.253294922855739f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","zytutb_dust"),ZYTUTB_DUST);
FuelRegistry.INSTANCE.add(ZYTUTB_DUST, 767);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "zytutb_block"), ZYTUTB_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "zytutb_block"), new BlockItem(ZYTUTB_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "zytutb_ore"), ZYTUTB_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "zytutb_ore"), new BlockItem(ZYTUTB_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_zytutb"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}