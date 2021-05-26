package fr.anatom3000.gwwhit.materials.obohylp;
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

public class ObohylpRoot  {
public static final ObohylpIngot OBOHYLP_INGOT = new ObohylpIngot();
public static final Block OBOHYLP_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.5004622224738062f,2.398680958661891f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block OBOHYLP_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.0640294887474742f,2.151694244997517f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final ObohylpSword OBOHYLP_SWORD = new ObohylpSword(ObohylpMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","obohylp_ingot"),OBOHYLP_INGOT);
FuelRegistry.INSTANCE.add(OBOHYLP_INGOT, 919);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "obohylp_block"), OBOHYLP_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "obohylp_block"), new BlockItem(OBOHYLP_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "obohylp_ore"), OBOHYLP_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "obohylp_ore"), new BlockItem(OBOHYLP_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","obohylp_sword"),OBOHYLP_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_obohylp"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}