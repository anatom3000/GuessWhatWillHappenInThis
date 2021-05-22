package fr.anatom3000.gwwhit.materials.giry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class GiryMaterial implements ToolMaterial {
public static final GiryMaterial INSTANCE = new GiryMaterial();

@Override
public int getDurability() {
return 1768;
}
@Override
public float getMiningSpeedMultiplier() {
return 13.871142529102059f;
}
@Override
public float getAttackDamage() {
return 7.986220222246949f;
}
@Override
public int getMiningLevel() {
return 1;
}
@Override
public int getEnchantability() {
return 15;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(GiryRoot.GIRY_DUST);
}
}