package fr.anatom3000.gwwhit.materials.icawlu;

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

public class IcawluRoot {
    public static final Item ICAWLU_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block ICAWLU_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.857869929715329f, 4.754838937487107f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).slipperiness(0.9732860557488623f));
    public static final Block ICAWLU_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5862001393079908f, 4.155325354252807f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final IcawluShovel ICAWLU_SHOVEL = new IcawluShovel(IcawluMaterial.INSTANCE);
    public static final IcawluPickaxe ICAWLU_PICKAXE = new IcawluPickaxe(IcawluMaterial.INSTANCE);
    public static final IcawluAxe ICAWLU_AXE = new IcawluAxe(IcawluMaterial.INSTANCE);
    public static final IcawluHoe ICAWLU_HOE = new IcawluHoe(IcawluMaterial.INSTANCE);
    public static final ArmorMaterial icawluArmorMaterial = new IcawluArmorMaterial();
    public static final IcawluHelmet ICAWLU_HELMET = new IcawluHelmet(icawluArmorMaterial);
    public static final IcawluChestplate ICAWLU_CHESTPLATE = new IcawluChestplate(icawluArmorMaterial);
    public static final IcawluLeggings ICAWLU_LEGGINGS = new IcawluLeggings(icawluArmorMaterial);
    public static final IcawluBoots ICAWLU_BOOTS = new IcawluBoots(icawluArmorMaterial);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_ingot"), ICAWLU_INGOT);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "icawlu_block"), ICAWLU_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_block"), new BlockItem(ICAWLU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "icawlu_ore"), ICAWLU_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_ore"), new BlockItem(ICAWLU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_shovel"), ICAWLU_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_pickaxe"), ICAWLU_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_axe"), ICAWLU_AXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_hoe"), ICAWLU_HOE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_helmet"), ICAWLU_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_chestplate"), ICAWLU_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_leggings"), ICAWLU_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "icawlu_boots"), ICAWLU_BOOTS);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_icawlu"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}