package fr.anatom3000.gwwhit.materials;

import fr.anatom3000.gwwhit.CustomItemGroups;

import java.util.Random;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import static fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod.MOD_ID;

public class CustomOre {

    public enum Type {
        Gem,
        Dust,
        Ingot
    }

    private enum ArmorType {
        Helmet,
        Chestplate,
        Leggings,
        Boots
    }

    public final Item material;
    public final Block ore;
    public final Block block;
    public final boolean hasArmor;
    public final boolean hasTools;
    public final boolean hasSword;
    
    private final Random rnd;
    private final Type type;
    private final String name;

    public CustomOre(String name, Type type, boolean hasArmor, boolean hasTools, boolean hasSword) {
        this.rnd = new Random(name.hashCode()^type.hashCode());
        this.type = type;
        this.hasArmor = hasArmor;
        this.hasTools = hasTools;
        this.hasSword = hasSword;
        this.name = name;
        this.material = new Item(new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
        this.ore = new Block(FabricBlockSettings.of(Material.STONE).strength((float)(rnd.nextDouble()*5), (float)(rnd.nextDouble()*5)).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, rnd.nextInt(3)));
        this.block = new Block(FabricBlockSettings.of(Material.STONE).strength((float)(rnd.nextDouble()*5), (float)(rnd.nextDouble()*5)).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, rnd.nextInt(3)));
    }

    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, getItemId()), material);
        if (rnd.nextDouble()<0.3D) FuelRegistry.INSTANCE.add(material, rnd.nextInt(1000));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, String.format("%s_block", name.toLowerCase())), block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_block", name.toLowerCase())), new BlockItem(block, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, String.format("%s_ore", name.toLowerCase())), ore);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_ore", name.toLowerCase())), new BlockItem(ore, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup)));
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(MOD_ID, String.format("ore_%s", name.toLowerCase())));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
        if (hasArmor) {
            ArmorMaterial material = getArmorMaterial();
            
            for (ArmorType t : ArmorType.values()) {
                createArmorItem(t, material);
            }

        }
        if (hasTools || hasSword) {
            ToolMaterial material = getToolMaterial();
            if (hasSword) {
                SwordItem swordItem = new CustomSword(material, rnd.nextInt(17),(float)(rnd.nextDouble()*3-1.0D), new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_sword", name.toLowerCase())), swordItem);
            }
            if (hasTools) {
                PickaxeItem pickaxeItem = new CustomPickaxe(material, rnd.nextInt(8),(float)(rnd.nextDouble()*3-1.0D), new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_pickaxe", name.toLowerCase())), pickaxeItem);

                ShovelItem shovelItem = new CustomShovel(material, (float)(rnd.nextDouble()*8),(float)(rnd.nextDouble()*3-1.0D), new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_shovel", name.toLowerCase())), shovelItem);

                AxeItem axeItem = new CustomAxe(material, (float)(rnd.nextDouble()*8),(float)(rnd.nextDouble()*3-1.0D), new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_axe", name.toLowerCase())), axeItem);

                HoeItem hoeItem = new CustomHoe(material, rnd.nextInt(8),(float)(rnd.nextDouble()*3-1.0D), new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_hoe", name.toLowerCase())), hoeItem);
            }
        }
    }

    public void onInitializeClient() {

    }

    private String getItemId() {
        if (type == Type.Gem) return name.toLowerCase();
        else return String.format("%s_%s", name.toLowerCase(), type.toString().toLowerCase());
    }

    private ArmorMaterial getArmorMaterial() {
        ArmorMaterial armorMaterial = new CustomArmorMaterial(
            rnd.nextInt(175-4)+4, 
            rnd.nextInt(20)+5, 
            material, 
            name.toLowerCase(), 
            (int)rnd.nextDouble()*3, 
            1, 
            (int)rnd.nextDouble()*5
        );
        return armorMaterial;
    }

    private ToolMaterial getToolMaterial() {
        ToolMaterial toolMaterial = new CustomToolMaterial(
            (float)(rnd.nextDouble()*8.5D), 
            rnd.nextInt(2100), 
            rnd.nextInt(15),
            rnd.nextInt(4)+1, 
            rnd.nextInt(20)+5, 
            material
        );
        return toolMaterial;
    }

    private void createArmorItem(ArmorType type, ArmorMaterial material) {
        ArmorItem item = new ArmorItem(material, geEquipmentSlot(type), new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_%s", name.toLowerCase(), type.toString().toLowerCase())), item);
    }

    private EquipmentSlot geEquipmentSlot(ArmorType type) {
        switch (type) {
            case Helmet:
                return EquipmentSlot.HEAD;
            
            case Chestplate:
                return EquipmentSlot.CHEST;

            case Leggings:
                return EquipmentSlot.LEGS;

            case Boots:
                return EquipmentSlot.FEET;
        
            default:
                break;
        }
        return null;
    }

    private class CustomSword extends SwordItem {

        public CustomSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
            super(toolMaterial, attackDamage, attackSpeed, settings);
        }

    }

    private class CustomPickaxe extends PickaxeItem {

        public CustomPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        
    }

    private class CustomShovel extends ShovelItem {

        public CustomShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        
    }

    private class CustomAxe extends AxeItem {

        public CustomAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }

    }

    private class CustomHoe extends HoeItem {

        public CustomHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }

    }

    private static class CustomArmorMaterial implements ArmorMaterial {

        public static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
        public static final int[] PROTECTION_VALUES = new int[]{1, 2, 3, 1};

        private final int durabilityMultiplier;
        private final int enchantibility;
        private final Item repairMaterial;
        private final String name;
        private final float knockbackResistance;
        private final int protection;
        private final float toughness;


        public CustomArmorMaterial(int durabilityMultiplier, int enchantibility, Item repairMaterial, String name, float knockbackResistance, int protection, float toughness) {
            this.durabilityMultiplier = durabilityMultiplier;
            this.enchantibility = enchantibility;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.knockbackResistance = knockbackResistance;
            this.protection = protection;
            this.toughness = toughness;
        }

        @Override
        public int getDurability(EquipmentSlot slot) {
            return BASE_DURABILITY[slot.getEntitySlotId()]*durabilityMultiplier;
        }

        @Override
        public int getEnchantability() {
            return enchantibility;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return PROTECTION_VALUES[slot.getEntitySlotId()]*protection;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(repairMaterial);
        }

        @Override
        public float getToughness() {
            return toughness;
        }

    }

    private final class CustomToolMaterial implements ToolMaterial {

        private final float attackDamage;
        private final int durability;
        private final int enchantibility;
        private final int miningLevel;
        private final float miningSpeedMultiplier;
        private final Item repairMaterial;
        
        public CustomToolMaterial(float attackDamage, int durability, int enchantibility, int miningLevel,
            float miningSpeedMultiplier, Item repairMaterial) {
            this.attackDamage = attackDamage;
            this.durability = durability;
            this.enchantibility = enchantibility;
            this.miningLevel = miningLevel;
            this.miningSpeedMultiplier = miningSpeedMultiplier;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getDurability() {
            return durability;
        }

        @Override
        public int getEnchantability() {
            return enchantibility;
        }

        @Override
        public int getMiningLevel() {
            return miningLevel;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return miningSpeedMultiplier;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(repairMaterial);
        }

    }
}