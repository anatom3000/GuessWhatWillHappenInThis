package fr.anatom3000.gwwhit.materials;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import fr.anatom3000.gwwhit.CustomItemGroups;

import java.util.Random;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import fr.anatom3000.gwwhit.config.ModConfig;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod.MOD_ID;

public class CustomOre {
    private static ItemGroup itemGroup;
    private final Dimension dimension;

    public enum Type {
        GEM,
        DUST,
        INGOT
    }
    
    public enum Dimension {
        OVERWORLD,
        NETHER,
        END
    }

    private enum ArmorType {
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS
    }

    public final Item material;
    public final Block ore;
    public final Block block;
    public final ConfiguredFeature<?, ?> feature;
    public final boolean hasArmor;
    public final boolean hasTools;
    public final boolean hasSword;
    
    private final Random rnd;
    private final Type type;
    private final String name;
    private final Identifier materialId;
    private final Identifier blockId;
    private final Identifier oreId;
    private final Identifier blockBlockId;
    private final Identifier oreBlockId;

    public CustomOre(String name, Type type, boolean hasArmor, boolean hasTools, boolean hasSword, Dimension dimension) {
        this.dimension = dimension;
        this.rnd = new Random(name.hashCode()^type.hashCode());
        this.type = type;
        this.hasArmor = hasArmor;
        this.hasTools = hasTools;
        this.hasSword = hasSword;
        this.name = name;
        materialId = new Identifier(MOD_ID, getItemId());
        blockId = new Identifier(MOD_ID, String.format("%s_block", name.toLowerCase()));
        oreId = new Identifier(MOD_ID, String.format("%s_ore", name.toLowerCase()));
        blockBlockId = new Identifier(MOD_ID, String.format("block/%s_block", name.toLowerCase()));
        oreBlockId = new Identifier(MOD_ID, String.format("block/%s_ore", name.toLowerCase()));
        this.material = new Item(createItemSettings());
        this.ore = new Block(FabricBlockSettings.of(Material.STONE).strength((float)(rnd.nextDouble()*5), (float)(rnd.nextDouble()*5)).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, rnd.nextInt(3)));
        this.block = new Block(FabricBlockSettings.of(Material.STONE).strength((float)(rnd.nextDouble()*5), (float)(rnd.nextDouble()*5)).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, rnd.nextInt(3)));
        this.feature = Feature.ORE
                .configure(new OreFeatureConfig(
                        dimension == Dimension.END ? new BlockMatchRuleTest(Blocks.END_STONE)
                                : dimension == Dimension.NETHER ? OreFeatureConfig.Rules.BASE_STONE_NETHER
                                : OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                        ore.getDefaultState(),
                        rnd.nextInt(16) + 4
                )).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                        0,
                        0,
                        rnd.nextInt(128) + 32
                )))
                .spreadHorizontally()
                .repeat(rnd.nextInt(12) + 4);
    }

    public void onInitialize() {
        if (itemGroup == null && ModConfig.getLoadedConfig().packs.moreOres.tab == ModConfig.Packs.MoreOres.Tab.SEPARATE) itemGroup = FabricItemGroupBuilder.create(GuessWhatWillHappenInThisMod.ID("more_ores")).icon(() -> new ItemStack(block)).build();;
        Registry.register(Registry.ITEM, materialId, material);
        if (rnd.nextDouble()<0.3D) FuelRegistry.INSTANCE.add(material, rnd.nextInt(1000));
        Registry.register(Registry.BLOCK, blockId, block);
        Registry.register(Registry.ITEM, blockId, new BlockItem(block, createItemSettings()));
        Registry.register(Registry.BLOCK, oreId, ore);
        Registry.register(Registry.ITEM, oreId, new BlockItem(ore, createItemSettings()));
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, oreId);
        if (ModConfig.getLoadedConfig().packs.moreOres.generateInWorld) BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
        if (hasArmor) {
            ArmorMaterial material = getArmorMaterial();
            
            for (ArmorType t : ArmorType.values()) {
                createArmorItem(t, material);
            }

        }
        if (hasTools || hasSword) {
            ToolMaterial material = getToolMaterial();
            if (hasSword) {
                SwordItem swordItem = new CustomSword(material, rnd.nextInt(17), (float) (rnd.nextDouble() * 3 - 1.0D), createItemSettings());
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_sword", name.toLowerCase())), swordItem);
            }
            if (hasTools) {
                PickaxeItem pickaxeItem = new CustomPickaxe(material, rnd.nextInt(8), (float) (rnd.nextDouble() * 3 - 1.0D), createItemSettings());
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_pickaxe", name.toLowerCase())), pickaxeItem);

                ShovelItem shovelItem = new CustomShovel(material, (float) (rnd.nextDouble() * 8), (float) (rnd.nextDouble() * 3 - 1.0D), createItemSettings());
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_shovel", name.toLowerCase())), shovelItem);

                AxeItem axeItem = new CustomAxe(material, (float) (rnd.nextDouble() * 8), (float) (rnd.nextDouble() * 3 - 1.0D), createItemSettings());
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_axe", name.toLowerCase())), axeItem);

                HoeItem hoeItem = new CustomHoe(material, rnd.nextInt(8), (float) (rnd.nextDouble() * 3 - 1.0D), createItemSettings());
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_hoe", name.toLowerCase())), hoeItem);
            }
        }

        RegistryKey<ConfiguredFeature<?, ?>> registryKey = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, oreId);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registryKey.getValue(), feature);
        BiomeModifications.addFeature(dimension == Dimension.END ? BiomeSelectors.foundInTheEnd()
                : dimension == Dimension.NETHER ? BiomeSelectors.foundInTheNether()
                : BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                registryKey);

        lootTableSimple("block");
        if (type == Type.INGOT) {
            lootTableSimple("ore");
        } else {
            JsonParser jp = new JsonParser();
            JsonElement predicate = jp.parse("{\"enchantments\": [{\"enchantment\": \"minecraft:silk_touch\", \"levels\": {\"min\": 1}}]}");
            double base = rnd.nextDouble() + 1;
            JsonElement count = jp.parse(String.format("{\"min\": %s, \"max\": %s, \"type\": \"minecraft:uniform\"}", base, base + rnd.nextDouble() * 2));
            JsonElement enchantmentParameters = jp.parse("{\"bonusMultiplier\": 1}");
            GuessWhatWillHappenInThisMod.RESOURCE_PACK.addLootTable(new Identifier(MOD_ID, String.format("blocks/%s_ore", name.toLowerCase())),
                    JLootTable.loot("minecraft:block").pool(JLootTable.pool().rolls(1)
                            .entry(JLootTable.entry().type("minecraft:alternatives")
                                    .child(JLootTable.entry()
                                            .name(oreId.toString())
                                            .type("minecraft:item")
                                            .condition(new JCondition("minecraft:match_tool").parameter("predicate", predicate))
                                    )
                                    .child(JLootTable.entry()
                                            .name(materialId.toString())
                                            .type("minecraft:item")
                                            .function(JLootTable.function("minecraft:set_count")
                                                    .parameter("count", count)
                                            )
                                            .function(JLootTable.function("minecraft:apply_bonus")
                                                    .parameter("enchantment", "minecraft:fortune")
                                                    .parameter("formula", "minecraft:uniform_bonus_count")
                                                    .parameter("parameters", enchantmentParameters)
                                            )
                                            .function("minecraft:explosion_decay")
                                    )
                            )
                    )
            );
        }
    }

    private void lootTableSimple(String suffix) {
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addLootTable(new Identifier(MOD_ID, String.format("blocks/%s_%s", name.toLowerCase(), suffix)),
                JLootTable.loot("minecraft:block").pool(JLootTable.pool().rolls(1)
                        .entry(JLootTable.entry().type("minecraft:item").name(String.format("%s:%s_%s", MOD_ID, name.toLowerCase(), suffix)))
                        .condition(new JCondition("minecraft:survives_explosion"))
                )
        );
    }

    public void onInitializeClient() {
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addModel(JModel.model()
                        .parent("minecraft:block/cube_all")
                        .textures(JModel.textures().var("all", blockBlockId.toString())),
                blockBlockId);

        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addModel(JModel.model()
                        .parent("minecraft:block/cube_all")
                        .textures(JModel.textures().var("all", oreBlockId.toString())),
                oreBlockId);

        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addBlockState(JState.state(JState.variant(JState.model(blockBlockId.toString()))), blockId);
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addBlockState(JState.state(JState.variant(JState.model(oreBlockId.toString()))), oreId);

        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addModel(JModel.model().parent(blockBlockId.toString()),
                new Identifier(MOD_ID, String.format("item/%s_block", name.toLowerCase())));
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addModel(JModel.model().parent(oreBlockId.toString()),
                new Identifier(MOD_ID, String.format("item/%s_ore", name.toLowerCase())));
        
        if (hasArmor) {
            generateBasicItemModel("_helmet");
            generateBasicItemModel("_chestplate");
            generateBasicItemModel("_leggings");
            generateBasicItemModel("_boots");
        }

        if (hasTools) {
            generateToolModel("pickaxe");
            generateToolModel("shovel");
            generateToolModel("axe");
            generateToolModel("hoe");
        }

        if (hasSword) {
            generateToolModel("sword");
        }

        switch (type) {
            case GEM:
                generateBasicItemModel("");
                break;
            case DUST:
                generateBasicItemModel("_dust");
                break;
            case INGOT:
                generateBasicItemModel("_ingot");
                break;
        }
    }

    private void generateToolModel(String type) {
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addModel(JModel.model().parent("minecraft:item/handheld")
                        .textures(JModel.textures().layer0(String.format("gwwhit:item/%s_%s", name.toLowerCase(), type))),
                new Identifier(MOD_ID, String.format("item/%s_%s", name.toLowerCase(), type)));
    }

    private void generateBasicItemModel(String type) {
        GuessWhatWillHappenInThisMod.RESOURCE_PACK.addModel(JModel.model().parent("minecraft:item/generated")
                        .textures(JModel.textures().layer0(String.format("gwwhit:item/%s%s", name.toLowerCase(), type))),
                new Identifier(MOD_ID, String.format("item/%s%s", name.toLowerCase(), type)));
    }

    private String getItemId() {
        if (type == Type.GEM) return name.toLowerCase();
        else return String.format("%s_%s", name.toLowerCase(), type.toString().toLowerCase());
    }

    private ArmorMaterial getArmorMaterial() {
        return new CustomArmorMaterial(
            rnd.nextInt(175-4)+4,
            rnd.nextInt(20)+5,
            material,
            name.toLowerCase(),
            (int)rnd.nextDouble()*3,
            1,
            (int)rnd.nextDouble()*5
        );
    }

    private ToolMaterial getToolMaterial() {
        return new CustomToolMaterial(
            (float)(rnd.nextDouble()*8.5D),
            rnd.nextInt(2100),
            rnd.nextInt(15),
            rnd.nextInt(4)+1,
            rnd.nextInt(20)+5,
            material
        );
    }

    private void createArmorItem(ArmorType type, ArmorMaterial material) {
        ArmorItem item = new ArmorItem(material, getEquipmentSlot(type), createItemSettings());
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, String.format("%s_%s", name.toLowerCase(), type.toString().toLowerCase())), item);
    }
    
    private FabricItemSettings createItemSettings() {
        FabricItemSettings settings = new FabricItemSettings();
        switch (ModConfig.getLoadedConfig().packs.moreOres.tab) {
            case MAIN:
                settings.group(CustomItemGroups.GWWHIT_GROUP);
                break;
            case SEPARATE:
                settings.group(itemGroup);
                break;
            
        }
        
        return settings;
    }

    private EquipmentSlot getEquipmentSlot(ArmorType type) {
        switch (type) {
            case HELMET:
                return EquipmentSlot.HEAD;
            
            case CHESTPLATE:
                return EquipmentSlot.CHEST;

            case LEGGINGS:
                return EquipmentSlot.LEGS;

            case BOOTS:
                return EquipmentSlot.FEET;
                
            default:
                throw new IllegalStateException("No case for enum value " + type);
                
        }
    }

    private static class CustomSword extends SwordItem {

        public CustomSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
            super(toolMaterial, attackDamage, attackSpeed, settings);
        }

    }

    private static class CustomPickaxe extends PickaxeItem {

        public CustomPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        
    }

    private static class CustomShovel extends ShovelItem {

        public CustomShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        
    }

    private static class CustomAxe extends AxeItem {

        public CustomAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }

    }

    private static class CustomHoe extends HoeItem {

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