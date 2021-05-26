package fr.anatom3000.gwwhit.materials.tetus;

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

public class TetusRoot {
    public static final Item TETUS = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block TETUS_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.941886912087864f, 2.9203945493438335f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.9215555875220989f));
    public static final Block TETUS_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.2374859739810793f, 4.074642410067934f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final TetusSword TETUS_SWORD = new TetusSword(TetusMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tetus"), TETUS);
        FuelRegistry.INSTANCE.add(TETUS, 576);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tetus_block"), TETUS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tetus_block"), new BlockItem(TETUS_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tetus_ore"), TETUS_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tetus_ore"), new BlockItem(TETUS_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tetus_sword"), TETUS_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_tetus"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}