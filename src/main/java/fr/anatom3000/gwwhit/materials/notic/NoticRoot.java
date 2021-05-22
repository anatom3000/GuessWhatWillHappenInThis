package fr.anatom3000.gwwhit.materials.notic;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class NoticRoot  {
public static final NoticDust NOTIC_DUST = new NoticDust();
public static final NoticBlock NOTIC_BLOCK = new NoticBlock();
public static final NoticOre NOTIC_ORE = new NoticOre();
public static final ArmorMaterial noticArmorMaterial = new NoticArmorMaterial();
public static final NoticHelmet NOTIC_HELMET = new NoticHelmet(noticArmorMaterial);
public static final NoticChestplate NOTIC_CHESTPLATE = new NoticChestplate(noticArmorMaterial);
public static final NoticLeggings NOTIC_LEGGINGS = new NoticLeggings(noticArmorMaterial);
public static final NoticBoots NOTIC_BOOTS = new NoticBoots(noticArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_dust"),NOTIC_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "notic_block"), NOTIC_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "notic_block"), new BlockItem(NOTIC_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "notic_ore"), NOTIC_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "notic_ore"), new BlockItem(NOTIC_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_helmet"),NOTIC_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_chestplate"),NOTIC_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_leggings"),NOTIC_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","notic_boots"),NOTIC_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_notic"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}