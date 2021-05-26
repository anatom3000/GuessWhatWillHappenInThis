package fr.anatom3000.gwwhit.materials.igekez;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
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

public class IgekezRoot  {
public static final IgekezIngot IGEKEZ_INGOT = new IgekezIngot();
public static final Block IGEKEZ_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.981758085844132f,2.9006502261373526f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final IgekezOre IGEKEZ_ORE = new IgekezOre();
public static final ArmorMaterial igekezArmorMaterial = new IgekezArmorMaterial();
public static final IgekezHelmet IGEKEZ_HELMET = new IgekezHelmet(igekezArmorMaterial);
public static final IgekezChestplate IGEKEZ_CHESTPLATE = new IgekezChestplate(igekezArmorMaterial);
public static final IgekezLeggings IGEKEZ_LEGGINGS = new IgekezLeggings(igekezArmorMaterial);
public static final IgekezBoots IGEKEZ_BOOTS = new IgekezBoots(igekezArmorMaterial);
public static final IgekezSword IGEKEZ_SWORD = new IgekezSword(IgekezMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","igekez_ingot"),IGEKEZ_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "igekez_block"), IGEKEZ_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "igekez_block"), new BlockItem(IGEKEZ_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "igekez_ore"), IGEKEZ_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "igekez_ore"), new BlockItem(IGEKEZ_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","igekez_helmet"),IGEKEZ_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","igekez_chestplate"),IGEKEZ_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","igekez_leggings"),IGEKEZ_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","igekez_boots"),IGEKEZ_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","igekez_sword"),IGEKEZ_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_igekez"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}