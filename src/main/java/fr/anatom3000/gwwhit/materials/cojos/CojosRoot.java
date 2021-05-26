package fr.anatom3000.gwwhit.materials.cojos;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class CojosRoot {
    public static final Item COJOS = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block COJOS_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.9424443425925553f, 3.118955856497523f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final Block COJOS_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.258951485803472f, 3.9675914010278306f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final CojosShovel COJOS_SHOVEL = new CojosShovel(CojosMaterial.INSTANCE);
    public static final CojosPickaxe COJOS_PICKAXE = new CojosPickaxe(CojosMaterial.INSTANCE);
    public static final CojosAxe COJOS_AXE = new CojosAxe(CojosMaterial.INSTANCE);
    public static final CojosHoe COJOS_HOE = new CojosHoe(CojosMaterial.INSTANCE);
    public static final CojosSword COJOS_SWORD = new CojosSword(CojosMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos"), COJOS);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "cojos_block"), COJOS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_block"), new BlockItem(COJOS_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "cojos_ore"), COJOS_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_ore"), new BlockItem(COJOS_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_shovel"), COJOS_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_pickaxe"), COJOS_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_axe"), COJOS_AXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_hoe"), COJOS_HOE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_sword"), COJOS_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_cojos"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}