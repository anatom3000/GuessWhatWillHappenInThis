package fr.anatom3000.gwwhit.materials.soneg;

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

public class SonegRoot {
    public static final Item SONEG_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block SONEG_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.893660516120522f, 1.9490018076857392f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block SONEG_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5540959459161985f, 3.7316446948963162f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final SonegSword SONEG_SWORD = new SonegSword(SonegMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "soneg_dust"), SONEG_DUST);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "soneg_block"), SONEG_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "soneg_block"), new BlockItem(SONEG_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "soneg_ore"), SONEG_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "soneg_ore"), new BlockItem(SONEG_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "soneg_sword"), SONEG_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_soneg"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}