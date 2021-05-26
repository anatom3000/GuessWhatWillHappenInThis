package fr.anatom3000.gwwhit.materials.ecywygs;

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

public class EcywygsRoot {
    public static final Item ECYWYGS = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    public static final Block ECYWYGS_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.3828486778747457f, 2.4402466979820847f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
    public static final Block ECYWYGS_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.646690681816971f, 1.4386801129848248f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
    public static final EcywygsShovel ECYWYGS_SHOVEL = new EcywygsShovel(EcywygsMaterial.INSTANCE);
    public static final EcywygsPickaxe ECYWYGS_PICKAXE = new EcywygsPickaxe(EcywygsMaterial.INSTANCE);
    public static final EcywygsAxe ECYWYGS_AXE = new EcywygsAxe(EcywygsMaterial.INSTANCE);
    public static final EcywygsHoe ECYWYGS_HOE = new EcywygsHoe(EcywygsMaterial.INSTANCE);
    public static final EcywygsSword ECYWYGS_SWORD = new EcywygsSword(EcywygsMaterial.INSTANCE);

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "ecywygs"), ECYWYGS);
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ecywygs_block"), ECYWYGS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "ecywygs_block"), new BlockItem(ECYWYGS_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ecywygs_ore"), ECYWYGS_ORE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "ecywygs_ore"), new BlockItem(ECYWYGS_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "ecywygs_shovel"), ECYWYGS_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "ecywygs_pickaxe"), ECYWYGS_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "ecywygs_axe"), ECYWYGS_AXE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "ecywygs_hoe"), ECYWYGS_HOE);
        Registry.register(Registry.ITEM, new Identifier("gwwhit", "ecywygs_sword"), ECYWYGS_SWORD);
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit", "ore_ecywygs"));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public void onInitializeClient() {

    }
}