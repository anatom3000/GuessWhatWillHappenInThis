package fr.anatom3000.gwwhit.materials.giry;
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

public class GiryRoot  {
public static final GiryDust GIRY_DUST = new GiryDust();
public static final Block GIRY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.650919625155666f,3.400853871662096f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block GIRY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5787943127478266f,1.815625046045092f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final ArmorMaterial giryArmorMaterial = new GiryArmorMaterial();
public static final GiryHelmet GIRY_HELMET = new GiryHelmet(giryArmorMaterial);
public static final GiryChestplate GIRY_CHESTPLATE = new GiryChestplate(giryArmorMaterial);
public static final GiryLeggings GIRY_LEGGINGS = new GiryLeggings(giryArmorMaterial);
public static final GiryBoots GIRY_BOOTS = new GiryBoots(giryArmorMaterial);
public static final GirySword GIRY_SWORD = new GirySword(GiryMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","giry_dust"),GIRY_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "giry_block"), GIRY_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "giry_block"), new BlockItem(GIRY_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "giry_ore"), GIRY_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "giry_ore"), new BlockItem(GIRY_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","giry_helmet"),GIRY_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","giry_chestplate"),GIRY_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","giry_leggings"),GIRY_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","giry_boots"),GIRY_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","giry_sword"),GIRY_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_giry"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}