package fr.anatom3000.gwwhit.materials.yfikal;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class YfikalMaterial implements ToolMaterial {
public static final YfikalMaterial INSTANCE = new YfikalMaterial();

@Override
public int getDurability() {
return 1414;
}
@Override
public float getMiningSpeedMultiplier() {
return 8.511177798724116f;
}
@Override
public float getAttackDamage() {
return 3.208880871916572f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 18;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(YfikalRoot.YFIKAL_INGOT);
}
}