package fr.anatom3000.gwwhit.materials.fucox;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class FucoxMaterial implements ToolMaterial {
public static final FucoxMaterial INSTANCE = new FucoxMaterial();

@Override
public int getDurability() {
return 124;
}
@Override
public float getMiningSpeedMultiplier() {
return 2.7344603461135906f;
}
@Override
public float getAttackDamage() {
return 4.830894789219554f;
}
@Override
public int getMiningLevel() {
return 1;
}
@Override
public int getEnchantability() {
return 9;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(FucoxRoot.FUCOX_DUST);
}
}