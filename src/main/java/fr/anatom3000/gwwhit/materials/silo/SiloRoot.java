package fr.anatom3000.gwwhit.materials.silo;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class SiloRoot {
    public static final Item SILO = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block SILO_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.458043006073042f, 1.0073381983237741f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).luminance(6));
    public static final Block SILO_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.9326458369384065f, 1.6891983454746753f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    public static final ArmorMaterial siloArmorMaterial = new SiloArmorMaterial();
    public static final SiloHelmet SILO_HELMET = new SiloHelmet(siloArmorMaterial);
    public static final SiloChestplate SILO_CHESTPLATE = new SiloChestplate(siloArmorMaterial);
    public static final SiloLeggings SILO_LEGGINGS = new SiloLeggings(siloArmorMaterial);
    public static final SiloBoots SILO_BOOTS = new SiloBoots(siloArmorMaterial);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "silo"), SILO);
        FuelRegistry.INSTANCE.add(SILO, 61);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "silo_block"), SILO_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "silo_block"), new BlockItem(SILO_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "silo_ore"), SILO_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "silo_ore"), new BlockItem(SILO_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "silo_helmet"), SILO_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "silo_chestplate"), SILO_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "silo_leggings"), SILO_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "silo_boots"), SILO_BOOTS);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_silo"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}