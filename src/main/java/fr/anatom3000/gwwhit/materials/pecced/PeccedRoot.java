package fr.anatom3000.gwwhit.materials.pecced;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class PeccedRoot  {
public static final PeccedDust PECCED_DUST = new PeccedDust();
public static final PeccedBlock PECCED_BLOCK = new PeccedBlock();
public static final PeccedOre PECCED_ORE = new PeccedOre();
public static final ArmorMaterial peccedArmorMaterial = new PeccedArmorMaterial();
public static final PeccedHelmet PECCED_HELMET = new PeccedHelmet(peccedArmorMaterial);
public static final PeccedChestplate PECCED_CHESTPLATE = new PeccedChestplate(peccedArmorMaterial);
public static final PeccedLeggings PECCED_LEGGINGS = new PeccedLeggings(peccedArmorMaterial);
public static final PeccedBoots PECCED_BOOTS = new PeccedBoots(peccedArmorMaterial);
public static final PeccedSword PECCED_SWORD = new PeccedSword(PeccedMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_dust"),PECCED_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "pecced_block"), PECCED_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "pecced_block"), new BlockItem(PECCED_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "pecced_ore"), PECCED_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "pecced_ore"), new BlockItem(PECCED_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_helmet"),PECCED_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_chestplate"),PECCED_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_leggings"),PECCED_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_boots"),PECCED_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","pecced_sword"),PECCED_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_pecced"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}