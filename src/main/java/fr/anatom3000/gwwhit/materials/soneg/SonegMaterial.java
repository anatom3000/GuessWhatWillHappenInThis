package fr.anatom3000.gwwhit.materials.soneg;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class SonegMaterial implements ToolMaterial {
public static final SonegMaterial INSTANCE = new SonegMaterial();

@Override
public int getDurability() {
return 861;
}
@Override
public float getMiningSpeedMultiplier() {
return 4.104654676048442f;
}
@Override
public float getAttackDamage() {
return 7.493235470772765f;
}
@Override
public int getMiningLevel() {
return 3;
}
@Override
public int getEnchantability() {
return 20;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(SonegRoot.SONEG_DUST);
}
}