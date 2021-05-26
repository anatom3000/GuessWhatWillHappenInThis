package fr.anatom3000.gwwhit.materials.tesxes;

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

public class TesxesRoot {
    public static final Item TESXES = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block TESXES_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.091801783598851f, 1.7926571357386263f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block TESXES_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.307610301978136f, 1.868869433512132f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tesxes"), TESXES);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tesxes_block"), TESXES_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tesxes_block"), new BlockItem(TESXES_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tesxes_ore"), TESXES_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tesxes_ore"), new BlockItem(TESXES_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_tesxes"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}