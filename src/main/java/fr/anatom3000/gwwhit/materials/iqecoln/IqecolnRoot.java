package fr.anatom3000.gwwhit.materials.iqecoln;

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

public class IqecolnRoot {
    public static final Item IQECOLN_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block IQECOLN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.088000516234878f, 3.681516034707085f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block IQECOLN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.821530597791218f, 2.387309768714658f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final ArmorMaterial iqecolnArmorMaterial = new IqecolnArmorMaterial();
    public static final IqecolnHelmet IQECOLN_HELMET = new IqecolnHelmet(iqecolnArmorMaterial);
    public static final IqecolnChestplate IQECOLN_CHESTPLATE = new IqecolnChestplate(iqecolnArmorMaterial);
    public static final IqecolnLeggings IQECOLN_LEGGINGS = new IqecolnLeggings(iqecolnArmorMaterial);
    public static final IqecolnBoots IQECOLN_BOOTS = new IqecolnBoots(iqecolnArmorMaterial);
    public static final IqecolnSword IQECOLN_SWORD = new IqecolnSword(IqecolnMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqecoln_ingot"), IQECOLN_INGOT);
        FuelRegistry.INSTANCE.add(IQECOLN_INGOT, 815);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "iqecoln_block"), IQECOLN_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqecoln_block"), new BlockItem(IQECOLN_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "iqecoln_ore"), IQECOLN_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqecoln_ore"), new BlockItem(IQECOLN_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqecoln_helmet"), IQECOLN_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqecoln_chestplate"), IQECOLN_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqecoln_leggings"), IQECOLN_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqecoln_boots"), IQECOLN_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqecoln_sword"), IQECOLN_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_iqecoln"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}