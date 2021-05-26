package fr.anatom3000.gwwhit.materials.tifut;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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

public class TifutRoot {
    public static final Item TIFUT_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block TIFUT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.4620588000155585f, 4.675500380358953f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block TIFUT_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.8208261943478092f, 4.715541266632633f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final ArmorMaterial tifutArmorMaterial = new TifutArmorMaterial();
    public static final TifutHelmet TIFUT_HELMET = new TifutHelmet(tifutArmorMaterial);
    public static final TifutChestplate TIFUT_CHESTPLATE = new TifutChestplate(tifutArmorMaterial);
    public static final TifutLeggings TIFUT_LEGGINGS = new TifutLeggings(tifutArmorMaterial);
    public static final TifutBoots TIFUT_BOOTS = new TifutBoots(tifutArmorMaterial);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tifut_ingot"), TIFUT_INGOT);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tifut_block"), TIFUT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tifut_block"), new BlockItem(TIFUT_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tifut_ore"), TIFUT_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tifut_ore"), new BlockItem(TIFUT_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tifut_helmet"), TIFUT_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tifut_chestplate"), TIFUT_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tifut_leggings"), TIFUT_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tifut_boots"), TIFUT_BOOTS);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_tifut"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}