package fr.anatom3000.gwwhit.materials.fyfat;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class FyfatRoot  {
public static final Fyfat FYFAT = new Fyfat();
public static final FyfatBlock FYFAT_BLOCK = new FyfatBlock();
public static final FyfatOre FYFAT_ORE = new FyfatOre();
public static final FyfatShovel FYFAT_SHOVEL = new FyfatShovel(FyfatMaterial.INSTANCE);
public static final FyfatPickaxe FYFAT_PICKAXE = new FyfatPickaxe(FyfatMaterial.INSTANCE);
public static final FyfatAxe FYFAT_AXE = new FyfatAxe(FyfatMaterial.INSTANCE);
public static final FyfatHoe FYFAT_HOE = new FyfatHoe(FyfatMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat"),FYFAT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fyfat_block"), FYFAT_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fyfat_block"), new BlockItem(FYFAT_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "fyfat_ore"), FYFAT_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "fyfat_ore"), new BlockItem(FYFAT_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat_shovel"),FYFAT_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat_pickaxe"),FYFAT_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat_axe"),FYFAT_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","fyfat_hoe"),FYFAT_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_fyfat"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}