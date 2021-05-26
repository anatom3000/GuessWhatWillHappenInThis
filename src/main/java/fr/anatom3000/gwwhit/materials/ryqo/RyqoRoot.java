package fr.anatom3000.gwwhit.materials.ryqo;
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

public class RyqoRoot  {
public static final RyqoDust RYQO_DUST = new RyqoDust();
public static final Block RYQO_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.568845296175102f,4.625908568029239f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final RyqoOre RYQO_ORE = new RyqoOre();
public static final ArmorMaterial ryqoArmorMaterial = new RyqoArmorMaterial();
public static final RyqoHelmet RYQO_HELMET = new RyqoHelmet(ryqoArmorMaterial);
public static final RyqoChestplate RYQO_CHESTPLATE = new RyqoChestplate(ryqoArmorMaterial);
public static final RyqoLeggings RYQO_LEGGINGS = new RyqoLeggings(ryqoArmorMaterial);
public static final RyqoBoots RYQO_BOOTS = new RyqoBoots(ryqoArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","ryqo_dust"),RYQO_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ryqo_block"), RYQO_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ryqo_block"), new BlockItem(RYQO_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ryqo_ore"), RYQO_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ryqo_ore"), new BlockItem(RYQO_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","ryqo_helmet"),RYQO_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ryqo_chestplate"),RYQO_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ryqo_leggings"),RYQO_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ryqo_boots"),RYQO_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_ryqo"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}