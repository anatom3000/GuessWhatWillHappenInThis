package fr.anatom3000.gwwhit.materials.sijtyw;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
public class SijtywArmorMaterial implements ArmorMaterial {
public static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
public static final int[] PROTECTION_VALUES = new int[] {1, 2, 3, 1};

@Override
public int getDurability(EquipmentSlot slot) {
return BASE_DURABILITY[slot.getEntitySlotId()] * 101;
}
@Override
public int getProtectionAmount(EquipmentSlot slot) {
return PROTECTION_VALUES[slot.getEntitySlotId()];
}
@Override
public int getEnchantability() {
return 7;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(SijtywRoot.SIJTYW);
}
@Override
public String getName() {
return "sijtyw";
}
@Override
public float getToughness() {
return 0.3291204047051499f;
}
@Override
public float getKnockbackResistance() {
return 1.0251173985819528f;
}
@Override
public SoundEvent getEquipSound() {
return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
}
}