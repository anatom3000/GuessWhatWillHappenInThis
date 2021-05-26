package fr.anatom3000.gwwhit.materials.folso;
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

public class FolsoRoot  {
public static final FolsoDust FOLSO_DUST = new FolsoDust();
public static final FolsoBlock FOLSO_BLOCK = new FolsoBlock();
public static final Block FOLSO_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.9096448850323977f,3.3389590472190553f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final FolsoShovel FOLSO_SHOVEL = new FolsoShovel(FolsoMaterial.INSTANCE);
public static final FolsoPickaxe FOLSO_PICKAXE = new FolsoPickaxe(FolsoMaterial.INSTANCE);
public static final FolsoAxe FOLSO_AXE = new FolsoAxe(FolsoMaterial.INSTANCE);
public static final FolsoHoe FOLSO_HOE = new FolsoHoe(FolsoMaterial.INSTANCE);
public static final FolsoSword FOLSO_SWORD = new FolsoSword(FolsoMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","folso_dust"),FOLSO_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "folso_block"), FOLSO_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "folso_block"), new BlockItem(FOLSO_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "folso_ore"), FOLSO_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "folso_ore"), new BlockItem(FOLSO_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","folso_shovel"),FOLSO_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","folso_pickaxe"),FOLSO_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","folso_axe"),FOLSO_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","folso_hoe"),FOLSO_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","folso_sword"),FOLSO_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_folso"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}