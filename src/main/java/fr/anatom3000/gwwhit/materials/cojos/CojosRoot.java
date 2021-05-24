package fr.anatom3000.gwwhit.materials.cojos;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class CojosRoot  {
public static final Cojos COJOS = new Cojos();
public static final CojosBlock COJOS_BLOCK = new CojosBlock();
public static final CojosOre COJOS_ORE = new CojosOre();
public static final CojosShovel COJOS_SHOVEL = new CojosShovel(CojosMaterial.INSTANCE);
public static final CojosPickaxe COJOS_PICKAXE = new CojosPickaxe(CojosMaterial.INSTANCE);
public static final CojosAxe COJOS_AXE = new CojosAxe(CojosMaterial.INSTANCE);
public static final CojosHoe COJOS_HOE = new CojosHoe(CojosMaterial.INSTANCE);
public static final CojosSword COJOS_SWORD = new CojosSword(CojosMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","cojos"),COJOS);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "cojos_block"), COJOS_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_block"), new BlockItem(COJOS_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "cojos_ore"), COJOS_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "cojos_ore"), new BlockItem(COJOS_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","cojos_shovel"),COJOS_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","cojos_pickaxe"),COJOS_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","cojos_axe"),COJOS_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","cojos_hoe"),COJOS_HOE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","cojos_sword"),COJOS_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_cojos"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}