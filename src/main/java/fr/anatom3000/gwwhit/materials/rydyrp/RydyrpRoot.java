package fr.anatom3000.gwwhit.materials.rydyrp;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class RydyrpRoot  {
public static final Rydyrp RYDYRP = new Rydyrp();
public static final RydyrpBlock RYDYRP_BLOCK = new RydyrpBlock();
public static final RydyrpOre RYDYRP_ORE = new RydyrpOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","rydyrp"),RYDYRP);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "rydyrp_block"), RYDYRP_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "rydyrp_block"), new BlockItem(RYDYRP_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "rydyrp_ore"), RYDYRP_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "rydyrp_ore"), new BlockItem(RYDYRP_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_rydyrp"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}