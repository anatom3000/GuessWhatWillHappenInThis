package fr.anatom3000.gwwhit.materials.emilamd;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class EmilamdRoot  {
public static final EmilamdIngot EMILAMD_INGOT = new EmilamdIngot();
public static final EmilamdBlock EMILAMD_BLOCK = new EmilamdBlock();
public static final EmilamdOre EMILAMD_ORE = new EmilamdOre();
public static final EmilamdSword EMILAMD_SWORD = new EmilamdSword(EmilamdMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","emilamd_ingot"),EMILAMD_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "emilamd_block"), EMILAMD_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "emilamd_block"), new BlockItem(EMILAMD_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "emilamd_ore"), EMILAMD_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "emilamd_ore"), new BlockItem(EMILAMD_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","emilamd_sword"),EMILAMD_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_emilamd"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}