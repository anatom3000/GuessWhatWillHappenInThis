package fr.anatom3000.gwwhit.materials.notic;
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
public class NoticRoot  {
public static final Item NOTIC_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final NoticBlock NOTIC_BLOCK = new NoticBlock();
public static final Block NOTIC_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.6419959483162745f,3.11053404379917f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final ArmorMaterial noticArmorMaterial = new NoticArmorMaterial();
public static final NoticHelmet NOTIC_HELMET = new NoticHelmet(noticArmorMaterial);
public static final NoticChestplate NOTIC_CHESTPLATE = new NoticChestplate(noticArmorMaterial);
public static final NoticLeggings NOTIC_LEGGINGS = new NoticLeggings(noticArmorMaterial);
public static final NoticBoots NOTIC_BOOTS = new NoticBoots(noticArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_dust"),NOTIC_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "notic_block"), NOTIC_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "notic_block"), new BlockItem(NOTIC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "notic_ore"), NOTIC_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "notic_ore"), new BlockItem(NOTIC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_helmet"),NOTIC_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_chestplate"),NOTIC_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_leggings"),NOTIC_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_boots"),NOTIC_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_notic"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}