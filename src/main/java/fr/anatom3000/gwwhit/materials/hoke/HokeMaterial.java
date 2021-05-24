package fr.anatom3000.gwwhit.materials.hoke;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class HokeMaterial implements ToolMaterial {
public static final HokeMaterial INSTANCE = new HokeMaterial();

@Override
public int getDurability() {
return 1378;
}
@Override
public float getMiningSpeedMultiplier() {
return 8.463410274540017f;
}
@Override
public float getAttackDamage() {
return 8.03652152710421f;
}
@Override
public int getMiningLevel() {
return 2;
}
@Override
public int getEnchantability() {
return 18;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(HokeRoot.HOKE_DUST);
}
}