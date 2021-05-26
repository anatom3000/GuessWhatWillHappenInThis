package fr.anatom3000.gwwhit.materials.mudatb;
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
public class MudatbRoot  {
public static final Item MUDATB = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block MUDATB_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.288711501040225f,2.304988035400448f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block MUDATB_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.6302105090144665f,4.963595127333379f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final MudatbShovel MUDATB_SHOVEL = new MudatbShovel(MudatbMaterial.INSTANCE);
public static final MudatbPickaxe MUDATB_PICKAXE = new MudatbPickaxe(MudatbMaterial.INSTANCE);
public static final MudatbAxe MUDATB_AXE = new MudatbAxe(MudatbMaterial.INSTANCE);
public static final MudatbHoe MUDATB_HOE = new MudatbHoe(MudatbMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","mudatb"),MUDATB);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "mudatb_block"), MUDATB_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "mudatb_block"), new BlockItem(MUDATB_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "mudatb_ore"), MUDATB_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "mudatb_ore"), new BlockItem(MUDATB_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","mudatb_shovel"),MUDATB_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mudatb_pickaxe"),MUDATB_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mudatb_axe"),MUDATB_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mudatb_hoe"),MUDATB_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_mudatb"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}