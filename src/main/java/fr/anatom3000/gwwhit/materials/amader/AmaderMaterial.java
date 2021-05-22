package fr.anatom3000.gwwhit.materials.amader;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class AmaderMaterial implements ToolMaterial {
public static final AmaderMaterial INSTANCE = new AmaderMaterial();

@Override
public int getDurability() {
return 786;
}
@Override
public float getMiningSpeedMultiplier() {
return 5.357356503236073f;
}
@Override
public float getAttackDamage() {
return 4.34733108531925f;
}
@Override
public int getMiningLevel() {
return 1;
}
@Override
public int getEnchantability() {
return 16;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(AmaderRoot.AMADER_INGOT);
}
}