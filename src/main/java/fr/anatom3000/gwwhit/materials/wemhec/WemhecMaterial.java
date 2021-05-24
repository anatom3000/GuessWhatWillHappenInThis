package fr.anatom3000.gwwhit.materials.wemhec;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class WemhecMaterial implements ToolMaterial {
public static final WemhecMaterial INSTANCE = new WemhecMaterial();

@Override
public int getDurability() {
return 189;
}
@Override
public float getMiningSpeedMultiplier() {
return 5.474687527484543f;
}
@Override
public float getAttackDamage() {
return 1.9964447696271475f;
}
@Override
public int getMiningLevel() {
return 1;
}
@Override
public int getEnchantability() {
return 17;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(WemhecRoot.WEMHEC);
}
}