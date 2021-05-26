package fr.anatom3000.gwwhit.materials.amader;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class AmaderArmorMaterial implements ArmorMaterial {
    public static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    public static final int[] PROTECTION_VALUES = new int[]{1, 2, 3, 1};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 120;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AmaderRoot.AMADER_INGOT);
    }

    @Override
    public String getName() {
        return "amader";
    }

    @Override
    public float getToughness() {
        return 1.571185167733935f;
    }

    @Override
    public float getKnockbackResistance() {
        return 2.3046471460551463f;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }
}