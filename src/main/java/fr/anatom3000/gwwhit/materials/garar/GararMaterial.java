package fr.anatom3000.gwwhit.materials.garar;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class GararMaterial implements ToolMaterial {
public static final GararMaterial INSTANCE = new GararMaterial();

@Override
public int getDurability() {
return 465;
}
@Override
public float getMiningSpeedMultiplier() {
return 14.875271327944963f;
}
@Override
public float getAttackDamage() {
return 2.867729434687936f;
}
@Override
public int getMiningLevel() {
return 3;
}
@Override
public int getEnchantability() {
return 23;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(GararRoot.GARAR_DUST);
}
}