package fr.anatom3000.gwwhit.materials.tidziq;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class TidziqMaterial implements ToolMaterial {
public static final TidziqMaterial INSTANCE = new TidziqMaterial();

@Override
public int getDurability() {
return 670;
}
@Override
public float getMiningSpeedMultiplier() {
return 11.826864539350964f;
}
@Override
public float getAttackDamage() {
return 1.931731746298726f;
}
@Override
public int getMiningLevel() {
return 1;
}
@Override
public int getEnchantability() {
return 11;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(TidziqRoot.TIDZIQ);
}
}