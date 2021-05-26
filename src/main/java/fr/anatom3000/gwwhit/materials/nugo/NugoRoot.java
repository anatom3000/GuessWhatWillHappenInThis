package fr.anatom3000.gwwhit.materials.nugo;
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

public class NugoRoot  {
public static final NugoDust NUGO_DUST = new NugoDust();
public static final Block NUGO_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.540433387192429f,4.765545385894495f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));
public static final Block NUGO_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5944410167235135f,2.9528731166038953f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).luminance(5));
public static final ArmorMaterial nugoArmorMaterial = new NugoArmorMaterial();
public static final NugoHelmet NUGO_HELMET = new NugoHelmet(nugoArmorMaterial);
public static final NugoChestplate NUGO_CHESTPLATE = new NugoChestplate(nugoArmorMaterial);
public static final NugoLeggings NUGO_LEGGINGS = new NugoLeggings(nugoArmorMaterial);
public static final NugoBoots NUGO_BOOTS = new NugoBoots(nugoArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_dust"),NUGO_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nugo_block"), NUGO_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nugo_block"), new BlockItem(NUGO_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nugo_ore"), NUGO_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nugo_ore"), new BlockItem(NUGO_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_helmet"),NUGO_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_chestplate"),NUGO_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_leggings"),NUGO_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_boots"),NUGO_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_nugo"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}