package fr.anatom3000.gwwhit.materials.emogy;

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

public class EmogyRoot {
    public static final Item EMOGY_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block EMOGY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.6645702079544282f, 3.385852761280221f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block EMOGY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5971413820150935f, 3.3921055132188536f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final ArmorMaterial emogyArmorMaterial = new EmogyArmorMaterial();
    public static final EmogyHelmet EMOGY_HELMET = new EmogyHelmet(emogyArmorMaterial);
    public static final EmogyChestplate EMOGY_CHESTPLATE = new EmogyChestplate(emogyArmorMaterial);
    public static final EmogyLeggings EMOGY_LEGGINGS = new EmogyLeggings(emogyArmorMaterial);
    public static final EmogyBoots EMOGY_BOOTS = new EmogyBoots(emogyArmorMaterial);
    public static final EmogySword EMOGY_SWORD = new EmogySword(EmogyMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_ingot"), EMOGY_INGOT);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "emogy_block"), EMOGY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_block"), new BlockItem(EMOGY_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "emogy_ore"), EMOGY_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_ore"), new BlockItem(EMOGY_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_helmet"), EMOGY_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_chestplate"), EMOGY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_leggings"), EMOGY_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_boots"), EMOGY_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_sword"), EMOGY_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_emogy"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}