package fr.anatom3000.gwwhit.materials.obohylp;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class ObohylpMaterial implements ToolMaterial {
public static final ObohylpMaterial INSTANCE = new ObohylpMaterial();

@Override
public int getDurability() {
return 1423;
}
@Override
public float getMiningSpeedMultiplier() {
return 10.759316162032206f;
}
@Override
public float getAttackDamage() {
return 3.340942450608667f;
}
@Override
public int getMiningLevel() {
return 2;
}
@Override
public int getEnchantability() {
return 10;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(ObohylpRoot.OBOHYLP_INGOT);
}
}