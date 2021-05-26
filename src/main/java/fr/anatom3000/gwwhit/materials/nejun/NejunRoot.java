package fr.anatom3000.gwwhit.materials.nejun;

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

public class NejunRoot {
    public static final Item NEJUN_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block NEJUN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.1418723658311514f, 3.2793034861422825f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block NEJUN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0202239094265817f, 2.2594521275959054f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final ArmorMaterial nejunArmorMaterial = new NejunArmorMaterial();
    public static final NejunHelmet NEJUN_HELMET = new NejunHelmet(nejunArmorMaterial);
    public static final NejunChestplate NEJUN_CHESTPLATE = new NejunChestplate(nejunArmorMaterial);
    public static final NejunLeggings NEJUN_LEGGINGS = new NejunLeggings(nejunArmorMaterial);
    public static final NejunBoots NEJUN_BOOTS = new NejunBoots(nejunArmorMaterial);
    public static final NejunSword NEJUN_SWORD = new NejunSword(NejunMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_ingot"), NEJUN_INGOT);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nejun_block"), NEJUN_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_block"), new BlockItem(NEJUN_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nejun_ore"), NEJUN_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_ore"), new BlockItem(NEJUN_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_helmet"), NEJUN_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_chestplate"), NEJUN_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_leggings"), NEJUN_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_boots"), NEJUN_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_sword"), NEJUN_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_nejun"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}