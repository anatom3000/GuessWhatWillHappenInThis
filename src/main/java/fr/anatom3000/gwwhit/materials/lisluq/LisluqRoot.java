package fr.anatom3000.gwwhit.materials.lisluq;

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

public class LisluqRoot {
    public static final Item LISLUQ = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final LisluqBlock LISLUQ_BLOCK = new LisluqBlock();
    public static final Block LISLUQ_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.86715504264314f, 4.521702004858694f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    public static final LisluqShovel LISLUQ_SHOVEL = new LisluqShovel(LisluqMaterial.INSTANCE);
    public static final LisluqPickaxe LISLUQ_PICKAXE = new LisluqPickaxe(LisluqMaterial.INSTANCE);
    public static final LisluqAxe LISLUQ_AXE = new LisluqAxe(LisluqMaterial.INSTANCE);
    public static final LisluqHoe LISLUQ_HOE = new LisluqHoe(LisluqMaterial.INSTANCE);
    public static final ArmorMaterial lisluqArmorMaterial = new LisluqArmorMaterial();
    public static final LisluqHelmet LISLUQ_HELMET = new LisluqHelmet(lisluqArmorMaterial);
    public static final LisluqChestplate LISLUQ_CHESTPLATE = new LisluqChestplate(lisluqArmorMaterial);
    public static final LisluqLeggings LISLUQ_LEGGINGS = new LisluqLeggings(lisluqArmorMaterial);
    public static final LisluqBoots LISLUQ_BOOTS = new LisluqBoots(lisluqArmorMaterial);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq"), LISLUQ);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lisluq_block"), LISLUQ_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_block"), new BlockItem(LISLUQ_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lisluq_ore"), LISLUQ_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_ore"), new BlockItem(LISLUQ_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_shovel"), LISLUQ_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_pickaxe"), LISLUQ_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_axe"), LISLUQ_AXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_hoe"), LISLUQ_HOE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_helmet"), LISLUQ_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_chestplate"), LISLUQ_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_leggings"), LISLUQ_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "lisluq_boots"), LISLUQ_BOOTS);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_lisluq"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}