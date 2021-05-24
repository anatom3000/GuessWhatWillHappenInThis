package fr.anatom3000.gwwhit.materials.obaseh;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class ObasehRoot  {
public static final ObasehIngot OBASEH_INGOT = new ObasehIngot();
public static final ObasehBlock OBASEH_BLOCK = new ObasehBlock();
public static final ObasehOre OBASEH_ORE = new ObasehOre();
public static final ObasehShovel OBASEH_SHOVEL = new ObasehShovel(ObasehMaterial.INSTANCE);
public static final ObasehPickaxe OBASEH_PICKAXE = new ObasehPickaxe(ObasehMaterial.INSTANCE);
public static final ObasehAxe OBASEH_AXE = new ObasehAxe(ObasehMaterial.INSTANCE);
public static final ObasehHoe OBASEH_HOE = new ObasehHoe(ObasehMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_ingot"),OBASEH_INGOT);
FuelRegistry.INSTANCE.add(OBASEH_INGOT, 113);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "obaseh_block"), OBASEH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "obaseh_block"), new BlockItem(OBASEH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "obaseh_ore"), OBASEH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "obaseh_ore"), new BlockItem(OBASEH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_shovel"),OBASEH_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_pickaxe"),OBASEH_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_axe"),OBASEH_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","obaseh_hoe"),OBASEH_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_obaseh"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}