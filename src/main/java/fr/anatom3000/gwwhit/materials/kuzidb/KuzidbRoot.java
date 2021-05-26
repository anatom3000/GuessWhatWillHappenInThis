package fr.anatom3000.gwwhit.materials.kuzidb;
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
import net.minecraft.item.Item;
public class KuzidbRoot  {
public static final Item KUZIDB_DUST = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
public static final KuzidbBlock KUZIDB_BLOCK = new KuzidbBlock();
public static final KuzidbOre KUZIDB_ORE = new KuzidbOre();
public static final ArmorMaterial kuzidbArmorMaterial = new KuzidbArmorMaterial();
public static final KuzidbHelmet KUZIDB_HELMET = new KuzidbHelmet(kuzidbArmorMaterial);
public static final KuzidbChestplate KUZIDB_CHESTPLATE = new KuzidbChestplate(kuzidbArmorMaterial);
public static final KuzidbLeggings KUZIDB_LEGGINGS = new KuzidbLeggings(kuzidbArmorMaterial);
public static final KuzidbBoots KUZIDB_BOOTS = new KuzidbBoots(kuzidbArmorMaterial);
public static final KuzidbSword KUZIDB_SWORD = new KuzidbSword(KuzidbMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","kuzidb_dust"),KUZIDB_DUST);
FuelRegistry.INSTANCE.add(KUZIDB_DUST, 865);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "kuzidb_block"), KUZIDB_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "kuzidb_block"), new BlockItem(KUZIDB_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "kuzidb_ore"), KUZIDB_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "kuzidb_ore"), new BlockItem(KUZIDB_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","kuzidb_helmet"),KUZIDB_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","kuzidb_chestplate"),KUZIDB_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","kuzidb_leggings"),KUZIDB_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","kuzidb_boots"),KUZIDB_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","kuzidb_sword"),KUZIDB_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_kuzidb"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}