package fr.anatom3000.gwwhit.materials.igekez;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
public class IgekezArmorMaterial implements ArmorMaterial {
public static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
public static final int[] PROTECTION_VALUES = new int[] {1, 2, 3, 1};

@Override
public int getDurability(EquipmentSlot slot) {
return BASE_DURABILITY[slot.getEntitySlotId()] * 21;
}
@Override
public int getProtectionAmount(EquipmentSlot slot) {
return PROTECTION_VALUES[slot.getEntitySlotId()];
}
@Override
public int getEnchantability() {
return 8;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(IgekezRoot.IGEKEZ_INGOT);
}
@Override
public String getName() {
return "igekez";
}
@Override
public float getToughness() {
return 3.6324478984494926f;
}
@Override
public float getKnockbackResistance() {
return 0.5871123406937975f;
}
@Override
public SoundEvent getEquipSound() {
return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
}
}