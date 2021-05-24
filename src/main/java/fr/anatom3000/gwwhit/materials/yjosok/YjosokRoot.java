package fr.anatom3000.gwwhit.materials.yjosok;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class YjosokRoot  {
public static final YjosokIngot YJOSOK_INGOT = new YjosokIngot();
public static final YjosokBlock YJOSOK_BLOCK = new YjosokBlock();
public static final YjosokOre YJOSOK_ORE = new YjosokOre();
public static final YjosokSword YJOSOK_SWORD = new YjosokSword(YjosokMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","yjosok_ingot"),YJOSOK_INGOT);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yjosok_block"), YJOSOK_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yjosok_block"), new BlockItem(YJOSOK_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "yjosok_ore"), YJOSOK_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "yjosok_ore"), new BlockItem(YJOSOK_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","yjosok_sword"),YJOSOK_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_yjosok"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}