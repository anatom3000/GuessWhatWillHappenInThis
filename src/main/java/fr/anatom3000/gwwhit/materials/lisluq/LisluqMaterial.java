package fr.anatom3000.gwwhit.materials.lisluq;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class LisluqMaterial implements ToolMaterial {
public static final LisluqMaterial INSTANCE = new LisluqMaterial();

@Override
public int getDurability() {
return 794;
}
@Override
public float getMiningSpeedMultiplier() {
return 1.2895506264073249f;
}
@Override
public float getAttackDamage() {
return 4.244329320008203f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 19;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(LisluqRoot.LISLUQ);
}
}