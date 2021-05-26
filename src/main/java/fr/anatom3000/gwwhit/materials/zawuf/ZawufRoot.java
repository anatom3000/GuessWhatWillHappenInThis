package fr.anatom3000.gwwhit.materials.zawuf;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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

public class ZawufRoot {
    public static final Item ZAWUF = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block ZAWUF_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.250817848767256f, 3.6778040632377955f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final Block ZAWUF_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.340466373211538f, 2.952277851046418f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final ZawufShovel ZAWUF_SHOVEL = new ZawufShovel(ZawufMaterial.INSTANCE);
    public static final ZawufPickaxe ZAWUF_PICKAXE = new ZawufPickaxe(ZawufMaterial.INSTANCE);
    public static final ZawufAxe ZAWUF_AXE = new ZawufAxe(ZawufMaterial.INSTANCE);
    public static final ZawufHoe ZAWUF_HOE = new ZawufHoe(ZawufMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "zawuf"), ZAWUF);
        FuelRegistry.INSTANCE.add(ZAWUF, 671);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "zawuf_block"), ZAWUF_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "zawuf_block"), new BlockItem(ZAWUF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "zawuf_ore"), ZAWUF_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "zawuf_ore"), new BlockItem(ZAWUF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "zawuf_shovel"), ZAWUF_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "zawuf_pickaxe"), ZAWUF_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "zawuf_axe"), ZAWUF_AXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "zawuf_hoe"), ZAWUF_HOE);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_zawuf"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}