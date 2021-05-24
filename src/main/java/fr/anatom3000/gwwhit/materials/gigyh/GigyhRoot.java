package fr.anatom3000.gwwhit.materials.gigyh;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class GigyhRoot  {
public static final Gigyh GIGYH = new Gigyh();
public static final GigyhBlock GIGYH_BLOCK = new GigyhBlock();
public static final GigyhOre GIGYH_ORE = new GigyhOre();
public static final ArmorMaterial gigyhArmorMaterial = new GigyhArmorMaterial();
public static final GigyhHelmet GIGYH_HELMET = new GigyhHelmet(gigyhArmorMaterial);
public static final GigyhChestplate GIGYH_CHESTPLATE = new GigyhChestplate(gigyhArmorMaterial);
public static final GigyhLeggings GIGYH_LEGGINGS = new GigyhLeggings(gigyhArmorMaterial);
public static final GigyhBoots GIGYH_BOOTS = new GigyhBoots(gigyhArmorMaterial);
public static final GigyhSword GIGYH_SWORD = new GigyhSword(GigyhMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","gigyh"),GIGYH);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "gigyh_block"), GIGYH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_block"), new BlockItem(GIGYH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "gigyh_ore"), GIGYH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "gigyh_ore"), new BlockItem(GIGYH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","gigyh_helmet"),GIGYH_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","gigyh_chestplate"),GIGYH_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","gigyh_leggings"),GIGYH_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","gigyh_boots"),GIGYH_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","gigyh_sword"),GIGYH_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_gigyh"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}