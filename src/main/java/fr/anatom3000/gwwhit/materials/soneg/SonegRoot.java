package fr.anatom3000.gwwhit.materials.soneg;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class SonegRoot  {
public static final SonegDust SONEG_DUST = new SonegDust();
public static final SonegBlock SONEG_BLOCK = new SonegBlock();
public static final SonegOre SONEG_ORE = new SonegOre();
public static final SonegSword SONEG_SWORD = new SonegSword(SonegMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","soneg_dust"),SONEG_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "soneg_block"), SONEG_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "soneg_block"), new BlockItem(SONEG_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "soneg_ore"), SONEG_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "soneg_ore"), new BlockItem(SONEG_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","soneg_sword"),SONEG_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_soneg"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}