package fr.anatom3000.gwwhit.materials.nugo;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
public class NugoRoot  {
public static final NugoDust NUGO_DUST = new NugoDust();
public static final NugoBlock NUGO_BLOCK = new NugoBlock();
public static final NugoOre NUGO_ORE = new NugoOre();
public static final ArmorMaterial nugoArmorMaterial = new NugoArmorMaterial();
public static final NugoHelmet NUGO_HELMET = new NugoHelmet(nugoArmorMaterial);
public static final NugoChestplate NUGO_CHESTPLATE = new NugoChestplate(nugoArmorMaterial);
public static final NugoLeggings NUGO_LEGGINGS = new NugoLeggings(nugoArmorMaterial);
public static final NugoBoots NUGO_BOOTS = new NugoBoots(nugoArmorMaterial);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_dust"),NUGO_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nugo_block"), NUGO_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nugo_block"), new BlockItem(NUGO_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "nugo_ore"), NUGO_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "nugo_ore"), new BlockItem(NUGO_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_helmet"),NUGO_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_chestplate"),NUGO_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_leggings"),NUGO_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","nugo_boots"),NUGO_BOOTS);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_nugo"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}