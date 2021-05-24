package fr.anatom3000.gwwhit.materials.mafab;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class MafabRoot  {
public static final Mafab MAFAB = new Mafab();
public static final MafabBlock MAFAB_BLOCK = new MafabBlock();
public static final MafabOre MAFAB_ORE = new MafabOre();
public static final MafabShovel MAFAB_SHOVEL = new MafabShovel(MafabMaterial.INSTANCE);
public static final MafabPickaxe MAFAB_PICKAXE = new MafabPickaxe(MafabMaterial.INSTANCE);
public static final MafabAxe MAFAB_AXE = new MafabAxe(MafabMaterial.INSTANCE);
public static final MafabHoe MAFAB_HOE = new MafabHoe(MafabMaterial.INSTANCE);
public static final ArmorMaterial mafabArmorMaterial = new MafabArmorMaterial();
public static final MafabHelmet MAFAB_HELMET = new MafabHelmet(mafabArmorMaterial);
public static final MafabChestplate MAFAB_CHESTPLATE = new MafabChestplate(mafabArmorMaterial);
public static final MafabLeggings MAFAB_LEGGINGS = new MafabLeggings(mafabArmorMaterial);
public static final MafabBoots MAFAB_BOOTS = new MafabBoots(mafabArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab"),MAFAB);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "mafab_block"), MAFAB_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "mafab_block"), new BlockItem(MAFAB_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "mafab_ore"), MAFAB_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "mafab_ore"), new BlockItem(MAFAB_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab_shovel"),MAFAB_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab_pickaxe"),MAFAB_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab_axe"),MAFAB_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab_hoe"),MAFAB_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab_helmet"),MAFAB_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab_chestplate"),MAFAB_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab_leggings"),MAFAB_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","mafab_boots"),MAFAB_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_mafab"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}