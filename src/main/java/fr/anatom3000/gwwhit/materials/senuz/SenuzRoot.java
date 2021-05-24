package fr.anatom3000.gwwhit.materials.senuz;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class SenuzRoot  {
public static final SenuzDust SENUZ_DUST = new SenuzDust();
public static final SenuzBlock SENUZ_BLOCK = new SenuzBlock();
public static final SenuzOre SENUZ_ORE = new SenuzOre();
public static final SenuzSword SENUZ_SWORD = new SenuzSword(SenuzMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","senuz_dust"),SENUZ_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "senuz_block"), SENUZ_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "senuz_block"), new BlockItem(SENUZ_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "senuz_ore"), SENUZ_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "senuz_ore"), new BlockItem(SENUZ_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","senuz_sword"),SENUZ_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_senuz"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}