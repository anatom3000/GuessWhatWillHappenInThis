package fr.anatom3000.gwwhit.materials.ijyqbag;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class IjyqbagRoot  {
public static final IjyqbagIngot IJYQBAG_INGOT = new IjyqbagIngot();
public static final Block IJYQBAG_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.440821872717974f,3.7070076935135803f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block IJYQBAG_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.59919753651398f,3.932431591499626f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final ArmorMaterial ijyqbagArmorMaterial = new IjyqbagArmorMaterial();
public static final IjyqbagHelmet IJYQBAG_HELMET = new IjyqbagHelmet(ijyqbagArmorMaterial);
public static final IjyqbagChestplate IJYQBAG_CHESTPLATE = new IjyqbagChestplate(ijyqbagArmorMaterial);
public static final IjyqbagLeggings IJYQBAG_LEGGINGS = new IjyqbagLeggings(ijyqbagArmorMaterial);
public static final IjyqbagBoots IJYQBAG_BOOTS = new IjyqbagBoots(ijyqbagArmorMaterial);
public static final IjyqbagSword IJYQBAG_SWORD = new IjyqbagSword(IjyqbagMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","ijyqbag_ingot"),IJYQBAG_INGOT);
FuelRegistry.INSTANCE.add(IJYQBAG_INGOT, 853);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ijyqbag_block"), IJYQBAG_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ijyqbag_block"), new BlockItem(IJYQBAG_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ijyqbag_ore"), IJYQBAG_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ijyqbag_ore"), new BlockItem(IJYQBAG_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","ijyqbag_helmet"),IJYQBAG_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ijyqbag_chestplate"),IJYQBAG_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ijyqbag_leggings"),IJYQBAG_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ijyqbag_boots"),IJYQBAG_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ijyqbag_sword"),IJYQBAG_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_ijyqbag"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}