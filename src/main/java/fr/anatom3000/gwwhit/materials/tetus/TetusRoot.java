package fr.anatom3000.gwwhit.materials.tetus;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class TetusRoot  {
public static final Tetus TETUS = new Tetus();
public static final Block TETUS_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.941886912087864f,2.9203945493438335f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.9215555875220989f));
public static final Block TETUS_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.2374859739810793f,4.074642410067934f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final TetusSword TETUS_SWORD = new TetusSword(TetusMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","tetus"),TETUS);
FuelRegistry.INSTANCE.add(TETUS, 576);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tetus_block"), TETUS_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tetus_block"), new BlockItem(TETUS_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tetus_ore"), TETUS_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tetus_ore"), new BlockItem(TETUS_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","tetus_sword"),TETUS_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_tetus"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}