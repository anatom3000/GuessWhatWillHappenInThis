package fr.anatom3000.gwwhit.materials.uberteg;
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

public class UbertegRoot  {
public static final UbertegIngot UBERTEG_INGOT = new UbertegIngot();
public static final Block UBERTEG_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.650320076307138f,1.3782695586894111f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block UBERTEG_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.839481016192175f,3.194925813277477f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final UbertegShovel UBERTEG_SHOVEL = new UbertegShovel(UbertegMaterial.INSTANCE);
public static final UbertegPickaxe UBERTEG_PICKAXE = new UbertegPickaxe(UbertegMaterial.INSTANCE);
public static final UbertegAxe UBERTEG_AXE = new UbertegAxe(UbertegMaterial.INSTANCE);
public static final UbertegHoe UBERTEG_HOE = new UbertegHoe(UbertegMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uberteg_ingot"),UBERTEG_INGOT);
FuelRegistry.INSTANCE.add(UBERTEG_INGOT, 607);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uberteg_block"), UBERTEG_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uberteg_block"), new BlockItem(UBERTEG_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uberteg_ore"), UBERTEG_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uberteg_ore"), new BlockItem(UBERTEG_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","uberteg_shovel"),UBERTEG_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uberteg_pickaxe"),UBERTEG_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uberteg_axe"),UBERTEG_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uberteg_hoe"),UBERTEG_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uberteg"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}