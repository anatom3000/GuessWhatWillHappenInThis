package fr.anatom3000.gwwhit.materials.dytap;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class DytapMaterial implements ToolMaterial {
public static final DytapMaterial INSTANCE = new DytapMaterial();

@Override
public int getDurability() {
return 1005;
}
@Override
public float getMiningSpeedMultiplier() {
return 14.923331385008746f;
}
@Override
public float getAttackDamage() {
return 3.6731878870911725f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 16;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(DytapRoot.DYTAP);
}
}