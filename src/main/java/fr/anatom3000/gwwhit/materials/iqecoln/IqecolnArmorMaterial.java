package fr.anatom3000.gwwhit.materials.iqecoln;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
public class IqecolnArmorMaterial implements ArmorMaterial {
public static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
public static final int[] PROTECTION_VALUES = new int[] {1, 2, 3, 1};

@Override
public int getDurability(EquipmentSlot slot) {
return BASE_DURABILITY[slot.getEntitySlotId()] * 23;
}
@Override
public int getProtectionAmount(EquipmentSlot slot) {
return PROTECTION_VALUES[slot.getEntitySlotId()];
}
@Override
public int getEnchantability() {
return 5;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(IqecolnRoot.IQECOLN_INGOT);
}
@Override
public String getName() {
return "iqecoln";
}
@Override
public float getToughness() {
return 0.6255850423903042f;
}
@Override
public float getKnockbackResistance() {
return 0.043079372289536844f;
}
@Override
public SoundEvent getEquipSound() {
return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
}
}