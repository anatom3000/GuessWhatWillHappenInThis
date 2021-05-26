package fr.anatom3000.gwwhit.materials.kuqoc;

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

public class KuqocRoot {
    public static final Item KUQOC_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block KUQOC_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.00056298568912f, 2.83465940238211f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
    public static final Block KUQOC_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.70339961008607f, 2.910770862862184f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final KuqocSword KUQOC_SWORD = new KuqocSword(KuqocMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "kuqoc_dust"), KUQOC_DUST);
        FuelRegistry.INSTANCE.add(KUQOC_DUST, 381);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "kuqoc_block"), KUQOC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "kuqoc_block"), new BlockItem(KUQOC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "kuqoc_ore"), KUQOC_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "kuqoc_ore"), new BlockItem(KUQOC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "kuqoc_sword"), KUQOC_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_kuqoc"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}