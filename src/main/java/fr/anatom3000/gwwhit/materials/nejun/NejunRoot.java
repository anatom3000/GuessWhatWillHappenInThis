package fr.anatom3000.gwwhit.materials.nejun;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class NejunRoot  {
public static final NejunIngot NEJUN_INGOT = new NejunIngot();
public static final NejunBlock NEJUN_BLOCK = new NejunBlock();
public static final NejunOre NEJUN_ORE = new NejunOre();
public static final ArmorMaterial nejunArmorMaterial = new NejunArmorMaterial();
public static final NejunHelmet NEJUN_HELMET = new NejunHelmet(nejunArmorMaterial);
public static final NejunChestplate NEJUN_CHESTPLATE = new NejunChestplate(nejunArmorMaterial);
public static final NejunLeggings NEJUN_LEGGINGS = new NejunLeggings(nejunArmorMaterial);
public static final NejunBoots NEJUN_BOOTS = new NejunBoots(nejunArmorMaterial);
public static final NejunSword NEJUN_SWORD = new NejunSword(NejunMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","nejun_ingot"),NEJUN_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nejun_block"), NEJUN_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_block"), new BlockItem(NEJUN_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nejun_ore"), NEJUN_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nejun_ore"), new BlockItem(NEJUN_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","nejun_helmet"),NEJUN_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nejun_chestplate"),NEJUN_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nejun_leggings"),NEJUN_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nejun_boots"),NEJUN_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nejun_sword"),NEJUN_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_nejun"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}