package fr.anatom3000.gwwhit.materials.emogy;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class EmogyRoot  {
public static final EmogyIngot EMOGY_INGOT = new EmogyIngot();
public static final EmogyBlock EMOGY_BLOCK = new EmogyBlock();
public static final EmogyOre EMOGY_ORE = new EmogyOre();
public static final ArmorMaterial emogyArmorMaterial = new EmogyArmorMaterial();
public static final EmogyHelmet EMOGY_HELMET = new EmogyHelmet(emogyArmorMaterial);
public static final EmogyChestplate EMOGY_CHESTPLATE = new EmogyChestplate(emogyArmorMaterial);
public static final EmogyLeggings EMOGY_LEGGINGS = new EmogyLeggings(emogyArmorMaterial);
public static final EmogyBoots EMOGY_BOOTS = new EmogyBoots(emogyArmorMaterial);
public static final EmogySword EMOGY_SWORD = new EmogySword(EmogyMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","emogy_ingot"),EMOGY_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "emogy_block"), EMOGY_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_block"), new BlockItem(EMOGY_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "emogy_ore"), EMOGY_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "emogy_ore"), new BlockItem(EMOGY_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","emogy_helmet"),EMOGY_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emogy_chestplate"),EMOGY_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emogy_leggings"),EMOGY_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emogy_boots"),EMOGY_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","emogy_sword"),EMOGY_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_emogy"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}