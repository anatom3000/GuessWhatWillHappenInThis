package fr.anatom3000.gwwhit.materials.iqola;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class IqolaArmorMaterial implements ArmorMaterial {
    public static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    public static final int[] PROTECTION_VALUES = new int[]{1, 2, 3, 1};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 85;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(IqolaRoot.IQOLA_INGOT);
    }

    @Override
    public String getName() {
        return "iqola";
    }

    @Override
    public float getToughness() {
        return 2.8001147570037945f;
    }

    @Override
    public float getKnockbackResistance() {
        return 2.754586673486622f;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }
}