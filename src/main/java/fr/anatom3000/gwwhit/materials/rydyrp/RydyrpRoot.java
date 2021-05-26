package fr.anatom3000.gwwhit.materials.rydyrp;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
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

import net.minecraft.item.Item;
public class RydyrpRoot  {
public static final Item RYDYRP = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block RYDYRP_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.8752172083406142f,1.9167528463130443f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.7405748679791418f));
public static final Block RYDYRP_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.535047459890229f,3.198590248363163f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","rydyrp"),RYDYRP);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "rydyrp_block"), RYDYRP_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "rydyrp_block"), new BlockItem(RYDYRP_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "rydyrp_ore"), RYDYRP_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "rydyrp_ore"), new BlockItem(RYDYRP_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_rydyrp"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}