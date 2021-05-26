package fr.anatom3000.gwwhit.materials.iqola;
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

public class IqolaRoot  {
public static final IqolaIngot IQOLA_INGOT = new IqolaIngot();
public static final Block IQOLA_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.6576814738711207f,1.6803113267782739f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block IQOLA_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.2267731278994045f,2.1412125703706155f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).luminance(3));
public static final ArmorMaterial iqolaArmorMaterial = new IqolaArmorMaterial();
public static final IqolaHelmet IQOLA_HELMET = new IqolaHelmet(iqolaArmorMaterial);
public static final IqolaChestplate IQOLA_CHESTPLATE = new IqolaChestplate(iqolaArmorMaterial);
public static final IqolaLeggings IQOLA_LEGGINGS = new IqolaLeggings(iqolaArmorMaterial);
public static final IqolaBoots IQOLA_BOOTS = new IqolaBoots(iqolaArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_ingot"),IQOLA_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "iqola_block"), IQOLA_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqola_block"), new BlockItem(IQOLA_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "iqola_ore"), IQOLA_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "iqola_ore"), new BlockItem(IQOLA_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_helmet"),IQOLA_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_chestplate"),IQOLA_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_leggings"),IQOLA_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","iqola_boots"),IQOLA_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_iqola"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}