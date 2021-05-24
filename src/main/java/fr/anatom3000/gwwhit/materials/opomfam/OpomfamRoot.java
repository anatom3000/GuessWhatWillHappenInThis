package fr.anatom3000.gwwhit.materials.opomfam;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class OpomfamRoot  {
public static final OpomfamIngot OPOMFAM_INGOT = new OpomfamIngot();
public static final OpomfamBlock OPOMFAM_BLOCK = new OpomfamBlock();
public static final OpomfamOre OPOMFAM_ORE = new OpomfamOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","opomfam_ingot"),OPOMFAM_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "opomfam_block"), OPOMFAM_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "opomfam_block"), new BlockItem(OPOMFAM_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "opomfam_ore"), OPOMFAM_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "opomfam_ore"), new BlockItem(OPOMFAM_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_opomfam"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}