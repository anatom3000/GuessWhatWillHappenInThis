package fr.anatom3000.gwwhit.materials.wemhec;
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

public class WemhecRoot  {
public static final Wemhec WEMHEC = new Wemhec();
public static final Block WEMHEC_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.44884632406108f,4.738354687675475f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block WEMHEC_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.8977757298471705f,3.2981670557700973f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final WemhecShovel WEMHEC_SHOVEL = new WemhecShovel(WemhecMaterial.INSTANCE);
public static final WemhecPickaxe WEMHEC_PICKAXE = new WemhecPickaxe(WemhecMaterial.INSTANCE);
public static final WemhecAxe WEMHEC_AXE = new WemhecAxe(WemhecMaterial.INSTANCE);
public static final WemhecHoe WEMHEC_HOE = new WemhecHoe(WemhecMaterial.INSTANCE);
public static final WemhecSword WEMHEC_SWORD = new WemhecSword(WemhecMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec"),WEMHEC);
FuelRegistry.INSTANCE.add(WEMHEC, 106);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "wemhec_block"), WEMHEC_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "wemhec_block"), new BlockItem(WEMHEC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "wemhec_ore"), WEMHEC_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "wemhec_ore"), new BlockItem(WEMHEC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_shovel"),WEMHEC_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_pickaxe"),WEMHEC_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_axe"),WEMHEC_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_hoe"),WEMHEC_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","wemhec_sword"),WEMHEC_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_wemhec"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}