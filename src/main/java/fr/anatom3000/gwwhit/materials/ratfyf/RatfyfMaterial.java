package fr.anatom3000.gwwhit.materials.ratfyf;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class RatfyfMaterial implements ToolMaterial {
public static final RatfyfMaterial INSTANCE = new RatfyfMaterial();

@Override
public int getDurability() {
return 404;
}
@Override
public float getMiningSpeedMultiplier() {
return 4.836808022919394f;
}
@Override
public float getAttackDamage() {
return 2.8741266765668536f;
}
@Override
public int getMiningLevel() {
return 4;
}
@Override
public int getEnchantability() {
return 25;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(RatfyfRoot.RATFYF_DUST);
}
}