package fr.anatom3000.gwwhit.materials.neqaw;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class NeqawMaterial implements ToolMaterial {
public static final NeqawMaterial INSTANCE = new NeqawMaterial();

@Override
public int getDurability() {
return 1499;
}
@Override
public float getMiningSpeedMultiplier() {
return 15.410085457375292f;
}
@Override
public float getAttackDamage() {
return 5.925007724949743f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 12;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(NeqawRoot.NEQAW);
}
}