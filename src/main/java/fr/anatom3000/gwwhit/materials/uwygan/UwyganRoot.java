package fr.anatom3000.gwwhit.materials.uwygan;

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

public class UwyganRoot {
    public static final Item UWYGAN_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block UWYGAN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.348603208170338f, 1.8438765823878045f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final Block UWYGAN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5811496723917084f, 2.910557168975662f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwygan_ingot"), UWYGAN_INGOT);
        FuelRegistry.INSTANCE.add(UWYGAN_INGOT, 667);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwygan_block"), UWYGAN_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwygan_block"), new BlockItem(UWYGAN_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uwygan_ore"), UWYGAN_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "uwygan_ore"), new BlockItem(UWYGAN_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_uwygan"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}