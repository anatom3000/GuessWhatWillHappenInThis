package fr.anatom3000.gwwhit.materials.uhyqol;

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

public class UhyqolRoot {
    public static final Item UHYQOL_INGOT = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final UhyqolBlock UHYQOL_BLOCK = new UhyqolBlock();
    public static final Block UHYQOL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.753951702568491f, 2.9066074406262907f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final UhyqolSword UHYQOL_SWORD = new UhyqolSword(UhyqolMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "uhyqol_ingot"), UHYQOL_INGOT);
        FuelRegistry.INSTANCE.add(UHYQOL_INGOT, 352);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uhyqol_block"), UHYQOL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "uhyqol_block"), new BlockItem(UHYQOL_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uhyqol_ore"), UHYQOL_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "uhyqol_ore"), new BlockItem(UHYQOL_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "uhyqol_sword"), UHYQOL_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_uhyqol"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}