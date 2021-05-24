package fr.anatom3000.gwwhit.materials.nejun;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class NejunMaterial implements ToolMaterial {
public static final NejunMaterial INSTANCE = new NejunMaterial();

@Override
public int getDurability() {
return 348;
}
@Override
public float getMiningSpeedMultiplier() {
return 9.996219651140906f;
}
@Override
public float getAttackDamage() {
return 2.984285308055737f;
}
@Override
public int getMiningLevel() {
return 1;
}
@Override
public int getEnchantability() {
return 6;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(NejunRoot.NEJUN_INGOT);
}
}