package fr.anatom3000.gwwhit.materials.neqaw;

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

public class NeqawRoot {
    public static final Item NEQAW = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block NEQAW_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.5969519643649353f, 2.1444373929339013f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block NEQAW_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.9556859209403212f, 1.4735036822625345f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    public static final ArmorMaterial neqawArmorMaterial = new NeqawArmorMaterial();
    public static final NeqawHelmet NEQAW_HELMET = new NeqawHelmet(neqawArmorMaterial);
    public static final NeqawChestplate NEQAW_CHESTPLATE = new NeqawChestplate(neqawArmorMaterial);
    public static final NeqawLeggings NEQAW_LEGGINGS = new NeqawLeggings(neqawArmorMaterial);
    public static final NeqawBoots NEQAW_BOOTS = new NeqawBoots(neqawArmorMaterial);
    public static final NeqawSword NEQAW_SWORD = new NeqawSword(NeqawMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw"), NEQAW);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "neqaw_block"), NEQAW_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_block"), new BlockItem(NEQAW_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "neqaw_ore"), NEQAW_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_ore"), new BlockItem(NEQAW_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_helmet"), NEQAW_HELMET);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_chestplate"), NEQAW_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_leggings"), NEQAW_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_boots"), NEQAW_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "neqaw_sword"), NEQAW_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_neqaw"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}