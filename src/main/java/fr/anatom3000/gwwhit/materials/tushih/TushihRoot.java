package fr.anatom3000.gwwhit.materials.tushih;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class TushihRoot  {
public static final TushihDust TUSHIH_DUST = new TushihDust();
public static final Block TUSHIH_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.435388534154923f,2.7252979966302475f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block TUSHIH_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.7391053259344154f,4.175071912502748f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final TushihSword TUSHIH_SWORD = new TushihSword(TushihMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","tushih_dust"),TUSHIH_DUST);
FuelRegistry.INSTANCE.add(TUSHIH_DUST, 963);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tushih_block"), TUSHIH_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tushih_block"), new BlockItem(TUSHIH_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "tushih_ore"), TUSHIH_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "tushih_ore"), new BlockItem(TUSHIH_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","tushih_sword"),TUSHIH_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_tushih"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}