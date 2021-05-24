package fr.anatom3000.gwwhit.materials.lotih;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class LotihRoot  {
public static final Lotih LOTIH = new Lotih();
public static final LotihBlock LOTIH_BLOCK = new LotihBlock();
public static final LotihOre LOTIH_ORE = new LotihOre();

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","lotih"),LOTIH);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lotih_block"), LOTIH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lotih_block"), new BlockItem(LOTIH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "lotih_ore"), LOTIH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "lotih_ore"), new BlockItem(LOTIH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_lotih"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}