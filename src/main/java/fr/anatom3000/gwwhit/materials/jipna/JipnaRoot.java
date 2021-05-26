package fr.anatom3000.gwwhit.materials.jipna;
import net.minecraft.util.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorMaterial;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class JipnaRoot  {
public static final JipnaDust JIPNA_DUST = new JipnaDust();
public static final Block JIPNA_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.011898314201292f,2.9745555629681393f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final Block JIPNA_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.0073136953248487f,4.0021043735890895f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));
public static final ArmorMaterial jipnaArmorMaterial = new JipnaArmorMaterial();
public static final JipnaHelmet JIPNA_HELMET = new JipnaHelmet(jipnaArmorMaterial);
public static final JipnaChestplate JIPNA_CHESTPLATE = new JipnaChestplate(jipnaArmorMaterial);
public static final JipnaLeggings JIPNA_LEGGINGS = new JipnaLeggings(jipnaArmorMaterial);
public static final JipnaBoots JIPNA_BOOTS = new JipnaBoots(jipnaArmorMaterial);
public static final JipnaSword JIPNA_SWORD = new JipnaSword(JipnaMaterial.INSTANCE);

public void onInitialize() {
Registry.register(Registry.ITEM, new Identifier("gwwhit","jipna_dust"),JIPNA_DUST);
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "jipna_block"), JIPNA_BLOCK);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "jipna_block"), new BlockItem(JIPNA_BLOCK, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.BLOCK, new Identifier("gwwhit", "jipna_ore"), JIPNA_ORE);
Registry.register(Registry.ITEM, new Identifier("gwwhit", "jipna_ore"), new BlockItem(JIPNA_ORE, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
Registry.register(Registry.ITEM, new Identifier("gwwhit","jipna_helmet"),JIPNA_HELMET);
Registry.register(Registry.ITEM, new Identifier("gwwhit","jipna_chestplate"),JIPNA_CHESTPLATE);
Registry.register(Registry.ITEM, new Identifier("gwwhit","jipna_leggings"),JIPNA_LEGGINGS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","jipna_boots"),JIPNA_BOOTS);
Registry.register(Registry.ITEM, new Identifier("gwwhit","jipna_sword"),JIPNA_SWORD);
RegistryKey<ConfiguredFeature<?,?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("gwwhit","ore_jipna"));
BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
}
public void onInitializeClient() {

}
}