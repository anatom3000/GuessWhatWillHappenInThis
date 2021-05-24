package fr.anatom3000.gwwhit.materials.ratfyf;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class RatfyfRoot  {
public static final RatfyfDust RATFYF_DUST = new RatfyfDust();
public static final RatfyfBlock RATFYF_BLOCK = new RatfyfBlock();
public static final RatfyfOre RATFYF_ORE = new RatfyfOre();
public static final RatfyfShovel RATFYF_SHOVEL = new RatfyfShovel(RatfyfMaterial.INSTANCE);
public static final RatfyfPickaxe RATFYF_PICKAXE = new RatfyfPickaxe(RatfyfMaterial.INSTANCE);
public static final RatfyfAxe RATFYF_AXE = new RatfyfAxe(RatfyfMaterial.INSTANCE);
public static final RatfyfHoe RATFYF_HOE = new RatfyfHoe(RatfyfMaterial.INSTANCE);
public static final ArmorMaterial ratfyfArmorMaterial = new RatfyfArmorMaterial();
public static final RatfyfHelmet RATFYF_HELMET = new RatfyfHelmet(ratfyfArmorMaterial);
public static final RatfyfChestplate RATFYF_CHESTPLATE = new RatfyfChestplate(ratfyfArmorMaterial);
public static final RatfyfLeggings RATFYF_LEGGINGS = new RatfyfLeggings(ratfyfArmorMaterial);
public static final RatfyfBoots RATFYF_BOOTS = new RatfyfBoots(ratfyfArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_dust"),RATFYF_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ratfyf_block"), RATFYF_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ratfyf_block"), new BlockItem(RATFYF_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "ratfyf_ore"), RATFYF_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "ratfyf_ore"), new BlockItem(RATFYF_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_shovel"),RATFYF_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_pickaxe"),RATFYF_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_axe"),RATFYF_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_hoe"),RATFYF_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_helmet"),RATFYF_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_chestplate"),RATFYF_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_leggings"),RATFYF_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","ratfyf_boots"),RATFYF_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_ratfyf"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}