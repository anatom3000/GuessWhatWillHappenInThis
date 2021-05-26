package fr.anatom3000.gwwhit.materials.lotih;
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

public class LotihRoot  {
public static final Lotih LOTIH = new Lotih();
public static final Block LOTIH_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.1264012626747317f,1.9996258300620537f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block LOTIH_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.9635176449072658f,2.425915213582175f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).luminance(1));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","lotih"),LOTIH);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lotih_block"), LOTIH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lotih_block"), new BlockItem(LOTIH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lotih_ore"), LOTIH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lotih_ore"), new BlockItem(LOTIH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_lotih"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}