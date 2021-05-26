package fr.anatom3000.gwwhit.materials.gycu;

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

public class GycuRoot {
    public static final Item GYCU = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block GYCU_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.892806394861206f, 4.7106023570127515f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block GYCU_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.6600150340942745f, 4.085745083863464f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    public static final ArmorMaterial gycuArmorMaterial = new GycuArmorMaterial();
    public static final GycuHelmet GYCU_HELMET = new GycuHelmet(gycuArmorMaterial);
    public static final GycuChestplate GYCU_CHESTPLATE = new GycuChestplate(gycuArmorMaterial);
    public static final GycuLeggings GYCU_LEGGINGS = new GycuLeggings(gycuArmorMaterial);
    public static final GycuBoots GYCU_BOOTS = new GycuBoots(gycuArmorMaterial);
    public static final GycuSword GYCU_SWORD = new GycuSword(GycuMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gycu"), GYCU);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "gycu_block"), GYCU_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gycu_block"), new BlockItem(GYCU_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "gycu_ore"), GYCU_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gycu_ore"), new BlockItem(GYCU_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gycu_helmet"), GYCU_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gycu_chestplate"), GYCU_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gycu_leggings"), GYCU_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gycu_boots"), GYCU_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "gycu_sword"), GYCU_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_gycu"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}