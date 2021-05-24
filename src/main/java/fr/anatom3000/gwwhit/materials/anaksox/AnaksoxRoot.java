package fr.anatom3000.gwwhit.materials.anaksox;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class AnaksoxRoot  {
public static final AnaksoxIngot ANAKSOX_INGOT = new AnaksoxIngot();
public static final AnaksoxBlock ANAKSOX_BLOCK = new AnaksoxBlock();
public static final AnaksoxOre ANAKSOX_ORE = new AnaksoxOre();
public static final AnaksoxShovel ANAKSOX_SHOVEL = new AnaksoxShovel(AnaksoxMaterial.INSTANCE);
public static final AnaksoxPickaxe ANAKSOX_PICKAXE = new AnaksoxPickaxe(AnaksoxMaterial.INSTANCE);
public static final AnaksoxAxe ANAKSOX_AXE = new AnaksoxAxe(AnaksoxMaterial.INSTANCE);
public static final AnaksoxHoe ANAKSOX_HOE = new AnaksoxHoe(AnaksoxMaterial.INSTANCE);
public static final ArmorMaterial anaksoxArmorMaterial = new AnaksoxArmorMaterial();
public static final AnaksoxHelmet ANAKSOX_HELMET = new AnaksoxHelmet(anaksoxArmorMaterial);
public static final AnaksoxChestplate ANAKSOX_CHESTPLATE = new AnaksoxChestplate(anaksoxArmorMaterial);
public static final AnaksoxLeggings ANAKSOX_LEGGINGS = new AnaksoxLeggings(anaksoxArmorMaterial);
public static final AnaksoxBoots ANAKSOX_BOOTS = new AnaksoxBoots(anaksoxArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_ingot"),ANAKSOX_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "anaksox_block"), ANAKSOX_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "anaksox_block"), new BlockItem(ANAKSOX_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "anaksox_ore"), ANAKSOX_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "anaksox_ore"), new BlockItem(ANAKSOX_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_shovel"),ANAKSOX_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_pickaxe"),ANAKSOX_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_axe"),ANAKSOX_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_hoe"),ANAKSOX_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_helmet"),ANAKSOX_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_chestplate"),ANAKSOX_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_leggings"),ANAKSOX_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","anaksox_boots"),ANAKSOX_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_anaksox"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}