package fr.anatom3000.gwwhit.materials.sushehn;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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

public class SushehnRoot {
    public static final Item SUSHEHN = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block SUSHEHN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.974011037506797f, 4.308521603054777f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final Block SUSHEHN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.042314900961967f, 4.535764279559878f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sushehn"), SUSHEHN);
        FuelRegistry.INSTANCE.add(SUSHEHN, 101);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "sushehn_block"), SUSHEHN_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sushehn_block"), new BlockItem(SUSHEHN_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "sushehn_ore"), SUSHEHN_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sushehn_ore"), new BlockItem(SUSHEHN_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_sushehn"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}