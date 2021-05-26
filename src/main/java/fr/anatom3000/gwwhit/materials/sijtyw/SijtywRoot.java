package fr.anatom3000.gwwhit.materials.sijtyw;

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

public class SijtywRoot {
    public static final Item SIJTYW = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block SIJTYW_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.87992097229947f, 3.6945125541360677f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final Block SIJTYW_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.3281622699266435f, 3.0974911198906443f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    public static final SijtywShovel SIJTYW_SHOVEL = new SijtywShovel(SijtywMaterial.INSTANCE);
    public static final SijtywPickaxe SIJTYW_PICKAXE = new SijtywPickaxe(SijtywMaterial.INSTANCE);
    public static final SijtywAxe SIJTYW_AXE = new SijtywAxe(SijtywMaterial.INSTANCE);
    public static final SijtywHoe SIJTYW_HOE = new SijtywHoe(SijtywMaterial.INSTANCE);
    public static final ArmorMaterial sijtywArmorMaterial = new SijtywArmorMaterial();
    public static final SijtywHelmet SIJTYW_HELMET = new SijtywHelmet(sijtywArmorMaterial);
    public static final SijtywChestplate SIJTYW_CHESTPLATE = new SijtywChestplate(sijtywArmorMaterial);
    public static final SijtywLeggings SIJTYW_LEGGINGS = new SijtywLeggings(sijtywArmorMaterial);
    public static final SijtywBoots SIJTYW_BOOTS = new SijtywBoots(sijtywArmorMaterial);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw"), SIJTYW);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "sijtyw_block"), SIJTYW_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_block"), new BlockItem(SIJTYW_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "sijtyw_ore"), SIJTYW_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_ore"), new BlockItem(SIJTYW_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_shovel"), SIJTYW_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_pickaxe"), SIJTYW_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_axe"), SIJTYW_AXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_hoe"), SIJTYW_HOE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_helmet"), SIJTYW_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_chestplate"), SIJTYW_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_leggings"), SIJTYW_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "sijtyw_boots"), SIJTYW_BOOTS);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_sijtyw"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}