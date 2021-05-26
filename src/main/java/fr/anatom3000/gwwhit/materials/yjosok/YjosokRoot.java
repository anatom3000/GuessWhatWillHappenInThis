package fr.anatom3000.gwwhit.materials.yjosok;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
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

public class YjosokRoot  {
public static final YjosokIngot YJOSOK_INGOT = new YjosokIngot();
public static final Block YJOSOK_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.5052900536412075f,1.8634806830581572f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));
public static final Block YJOSOK_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.3993136294626387f,4.010573373808318f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
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