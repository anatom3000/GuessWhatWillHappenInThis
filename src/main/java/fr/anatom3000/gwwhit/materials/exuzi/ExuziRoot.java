package fr.anatom3000.gwwhit.materials.exuzi;
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
public class ExuziRoot  {
public static final ExuziIngot EXUZI_INGOT = new ExuziIngot();
public static final ExuziBlock EXUZI_BLOCK = new ExuziBlock();
public static final ExuziOre EXUZI_ORE = new ExuziOre();
public static final ArmorMaterial exuziArmorMaterial = new ExuziArmorMaterial();
public static final ExuziHelmet EXUZI_HELMET = new ExuziHelmet(exuziArmorMaterial);
public static final ExuziChestplate EXUZI_CHESTPLATE = new ExuziChestplate(exuziArmorMaterial);
public static final ExuziLeggings EXUZI_LEGGINGS = new ExuziLeggings(exuziArmorMaterial);
public static final ExuziBoots EXUZI_BOOTS = new ExuziBoots(exuziArmorMaterial);
public static final ExuziSword EXUZI_SWORD = new ExuziSword(ExuziMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","exuzi_ingot"),EXUZI_INGOT);
FuelRegistry.INSTANCE.add(EXUZI_INGOT, 502);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "exuzi_block"), EXUZI_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "exuzi_block"), new BlockItem(EXUZI_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "exuzi_ore"), EXUZI_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "exuzi_ore"), new BlockItem(EXUZI_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","exuzi_helmet"),EXUZI_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","exuzi_chestplate"),EXUZI_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","exuzi_leggings"),EXUZI_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","exuzi_boots"),EXUZI_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","exuzi_sword"),EXUZI_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_exuzi"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}