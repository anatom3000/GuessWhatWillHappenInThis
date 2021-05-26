package fr.anatom3000.gwwhit.materials.opomfam;

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

public class OpomfamRoot {
    public static final Item OPOMFAM_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block OPOMFAM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.9637485785869853f, 3.445130065905783f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block OPOMFAM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.37022927511029f, 3.238710326358524f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "opomfam_ingot"), OPOMFAM_INGOT);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "opomfam_block"), OPOMFAM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "opomfam_block"), new BlockItem(OPOMFAM_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "opomfam_ore"), OPOMFAM_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "opomfam_ore"), new BlockItem(OPOMFAM_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_opomfam"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}