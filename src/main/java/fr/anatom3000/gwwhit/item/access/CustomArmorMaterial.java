package fr.anatom3000.gwwhit.item.access;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public record CustomArmorMaterial(int durabilityMultiplier,
                                  int enchantibility,
                                  Item repairMaterial,
                                  String name,
                                  float knockbackResistance,
                                  int protection,
                                  float toughness) implements ArmorMaterial {

    public static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    public static final int[] PROTECTION_VALUES = new int[]{1, 2, 3, 1};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * durabilityMultiplier;
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
        return PROTECTION_VALUES[slot.getEntitySlotId()] * protection;
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
