package fr.anatom3000.gwwhit.materials.botud;
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

public class BotudRoot  {
public static final Botud BOTUD = new Botud();
public static final Block BOTUD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(1.895546018727078f,1.647412322453087f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block BOTUD_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.424393544424001f,4.2406564361777965f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final BotudShovel BOTUD_SHOVEL = new BotudShovel(BotudMaterial.INSTANCE);
public static final BotudPickaxe BOTUD_PICKAXE = new BotudPickaxe(BotudMaterial.INSTANCE);
public static final BotudAxe BOTUD_AXE = new BotudAxe(BotudMaterial.INSTANCE);
public static final BotudHoe BOTUD_HOE = new BotudHoe(BotudMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","botud"),BOTUD);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "botud_block"), BOTUD_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "botud_block"), new BlockItem(BOTUD_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "botud_ore"), BOTUD_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "botud_ore"), new BlockItem(BOTUD_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","botud_shovel"),BOTUD_SHOVEL);
Registry.register(Registry.ITEM, new Identifier("gwwhit","botud_pickaxe"),BOTUD_PICKAXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","botud_axe"),BOTUD_AXE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","botud_hoe"),BOTUD_HOE);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_botud"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}