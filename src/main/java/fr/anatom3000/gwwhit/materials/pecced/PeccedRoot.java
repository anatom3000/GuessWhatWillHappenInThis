package fr.anatom3000.gwwhit.materials.pecced;
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

import net.minecraft.item.Item;
public class PeccedRoot  {
public static final Item PECCED_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final Block PECCED_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(2.6010260796534825f,2.3127495119359955f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final PeccedOre PECCED_ORE = new PeccedOre();
public static final ArmorMaterial peccedArmorMaterial = new PeccedArmorMaterial();
public static final PeccedHelmet PECCED_HELMET = new PeccedHelmet(peccedArmorMaterial);
public static final PeccedChestplate PECCED_CHESTPLATE = new PeccedChestplate(peccedArmorMaterial);
public static final PeccedLeggings PECCED_LEGGINGS = new PeccedLeggings(peccedArmorMaterial);
public static final PeccedBoots PECCED_BOOTS = new PeccedBoots(peccedArmorMaterial);
public static final PeccedSword PECCED_SWORD = new PeccedSword(PeccedMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_dust"),PECCED_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "pecced_block"), PECCED_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "pecced_block"), new BlockItem(PECCED_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "pecced_ore"), PECCED_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "pecced_ore"), new BlockItem(PECCED_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_helmet"),PECCED_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_chestplate"),PECCED_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_leggings"),PECCED_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_boots"),PECCED_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_sword"),PECCED_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_pecced"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}