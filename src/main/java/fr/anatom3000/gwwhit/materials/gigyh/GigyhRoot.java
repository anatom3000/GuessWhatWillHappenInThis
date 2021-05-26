package fr.anatom3000.gwwhit.materials.gigyh;

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

public class GigyhRoot {
    public static final Item GIGYH = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block GIGYH_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.514542120625487f, 4.762194860120045f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block GIGYH_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.6065300153686977f, 3.2447097769978046f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final ArmorMaterial gigyhArmorMaterial = new GigyhArmorMaterial();
    public static final GigyhHelmet GIGYH_HELMET = new GigyhHelmet(gigyhArmorMaterial);
    public static final GigyhChestplate GIGYH_CHESTPLATE = new GigyhChestplate(gigyhArmorMaterial);
    public static final GigyhLeggings GIGYH_LEGGINGS = new GigyhLeggings(gigyhArmorMaterial);
    public static final GigyhBoots GIGYH_BOOTS = new GigyhBoots(gigyhArmorMaterial);
    public static final GigyhSword GIGYH_SWORD = new GigyhSword(GigyhMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh"), GIGYH);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "gigyh_block"), GIGYH_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_block"), new BlockItem(GIGYH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "gigyh_ore"), GIGYH_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_ore"), new BlockItem(GIGYH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_helmet"), GIGYH_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_chestplate"), GIGYH_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_leggings"), GIGYH_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_boots"), GIGYH_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_sword"), GIGYH_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_gigyh"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}