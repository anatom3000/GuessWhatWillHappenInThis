package fr.anatom3000.gwwhit.materials.asymcof;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class AsymcofMaterial implements ToolMaterial {
public static final AsymcofMaterial INSTANCE = new AsymcofMaterial();

@Override
public int getDurability() {
return 239;
}
@Override
public float getMiningSpeedMultiplier() {
return 4.475000314115164f;
}
@Override
public float getAttackDamage() {
return 3.206452453770737f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 17;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(AsymcofRoot.ASYMCOF_INGOT);
}
}