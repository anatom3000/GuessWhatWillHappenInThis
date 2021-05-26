package fr.anatom3000.gwwhit.materials.lywyg;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class LywygRoot {
    public static final Item LYWYG = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block LYWYG_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.750797031209085f, 1.5024434389763544f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block LYWYG_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.59928814427294f, 4.1831631822680775f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lywyg"), LYWYG);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lywyg_block"), LYWYG_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lywyg_block"), new BlockItem(LYWYG_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lywyg_ore"), LYWYG_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lywyg_ore"), new BlockItem(LYWYG_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_lywyg"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}