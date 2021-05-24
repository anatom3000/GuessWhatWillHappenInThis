package fr.anatom3000.gwwhit.materials.foqepm;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class FoqepmRoot  {
public static final Foqepm FOQEPM = new Foqepm();
public static final FoqepmBlock FOQEPM_BLOCK = new FoqepmBlock();
public static final FoqepmOre FOQEPM_ORE = new FoqepmOre();
public static final FoqepmShovel FOQEPM_SHOVEL = new FoqepmShovel(FoqepmMaterial.INSTANCE);
public static final FoqepmPickaxe FOQEPM_PICKAXE = new FoqepmPickaxe(FoqepmMaterial.INSTANCE);
public static final FoqepmAxe FOQEPM_AXE = new FoqepmAxe(FoqepmMaterial.INSTANCE);
public static final FoqepmHoe FOQEPM_HOE = new FoqepmHoe(FoqepmMaterial.INSTANCE);
public static final FoqepmSword FOQEPM_SWORD = new FoqepmSword(FoqepmMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","foqepm"),FOQEPM);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "foqepm_block"), FOQEPM_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "foqepm_block"), new BlockItem(FOQEPM_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "foqepm_ore"), FOQEPM_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "foqepm_ore"), new BlockItem(FOQEPM_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","foqepm_shovel"),FOQEPM_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","foqepm_pickaxe"),FOQEPM_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","foqepm_axe"),FOQEPM_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","foqepm_hoe"),FOQEPM_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","foqepm_sword"),FOQEPM_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_foqepm"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}