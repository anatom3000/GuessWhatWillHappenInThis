package fr.anatom3000.gwwhit.materials.lysum;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class LysumMaterial implements ToolMaterial {
public static final LysumMaterial INSTANCE = new LysumMaterial();

@Override
public int getDurability() {
return 50;
}
@Override
public float getMiningSpeedMultiplier() {
return 4.687757389005707f;
}
@Override
public float getAttackDamage() {
return 2.523407789989572f;
}
@Override
public int getMiningLevel() {
return 4;
}
@Override
public int getEnchantability() {
return 20;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(LysumRoot.LYSUM);
}
}