package fr.anatom3000.gwwhit.materials.tushih;

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

public class TushihRoot {
    public static final Item TUSHIH_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block TUSHIH_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.435388534154923f, 2.7252979966302475f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block TUSHIH_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.7391053259344154f, 4.175071912502748f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final TushihSword TUSHIH_SWORD = new TushihSword(TushihMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tushih_dust"), TUSHIH_DUST);
        FuelRegistry.INSTANCE.add(TUSHIH_DUST, 963);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tushih_block"), TUSHIH_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tushih_block"), new BlockItem(TUSHIH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tushih_ore"), TUSHIH_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tushih_ore"), new BlockItem(TUSHIH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "tushih_sword"), TUSHIH_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_tushih"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}