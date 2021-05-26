package fr.anatom3000.gwwhit.materials.uruwogq;
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

public class UruwogqRoot  {
public static final UruwogqIngot URUWOGQ_INGOT = new UruwogqIngot();
public static final UruwogqBlock URUWOGQ_BLOCK = new UruwogqBlock();
public static final Block URUWOGQ_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.326361572300289f,2.987653755665146f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final ArmorMaterial uruwogqArmorMaterial = new UruwogqArmorMaterial();
public static final UruwogqHelmet URUWOGQ_HELMET = new UruwogqHelmet(uruwogqArmorMaterial);
public static final UruwogqChestplate URUWOGQ_CHESTPLATE = new UruwogqChestplate(uruwogqArmorMaterial);
public static final UruwogqLeggings URUWOGQ_LEGGINGS = new UruwogqLeggings(uruwogqArmorMaterial);
public static final UruwogqBoots URUWOGQ_BOOTS = new UruwogqBoots(uruwogqArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","uruwogq_ingot"),URUWOGQ_INGOT);
FuelRegistry.INSTANCE.add(URUWOGQ_INGOT, 164);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uruwogq_block"), URUWOGQ_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uruwogq_block"), new BlockItem(URUWOGQ_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "uruwogq_ore"), URUWOGQ_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "uruwogq_ore"), new BlockItem(URUWOGQ_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","uruwogq_helmet"),URUWOGQ_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uruwogq_chestplate"),URUWOGQ_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uruwogq_leggings"),URUWOGQ_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","uruwogq_boots"),URUWOGQ_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_uruwogq"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}