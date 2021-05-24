package fr.anatom3000.gwwhit.materials.oquge;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class OqugeRoot  {
public static final OqugeIngot OQUGE_INGOT = new OqugeIngot();
public static final OqugeBlock OQUGE_BLOCK = new OqugeBlock();
public static final OqugeOre OQUGE_ORE = new OqugeOre();
public static final ArmorMaterial oqugeArmorMaterial = new OqugeArmorMaterial();
public static final OqugeHelmet OQUGE_HELMET = new OqugeHelmet(oqugeArmorMaterial);
public static final OqugeChestplate OQUGE_CHESTPLATE = new OqugeChestplate(oqugeArmorMaterial);
public static final OqugeLeggings OQUGE_LEGGINGS = new OqugeLeggings(oqugeArmorMaterial);
public static final OqugeBoots OQUGE_BOOTS = new OqugeBoots(oqugeArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","oquge_ingot"),OQUGE_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "oquge_block"), OQUGE_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "oquge_block"), new BlockItem(OQUGE_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "oquge_ore"), OQUGE_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "oquge_ore"), new BlockItem(OQUGE_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","oquge_helmet"),OQUGE_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","oquge_chestplate"),OQUGE_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","oquge_leggings"),OQUGE_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","oquge_boots"),OQUGE_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_oquge"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}