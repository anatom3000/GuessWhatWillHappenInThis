package fr.anatom3000.gwwhit.materials.pecced;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class PeccedMaterial implements ToolMaterial {
public static final PeccedMaterial INSTANCE = new PeccedMaterial();

@Override
public int getDurability() {
return 1014;
}
@Override
public float getMiningSpeedMultiplier() {
return 7.676054094982948f;
}
@Override
public float getAttackDamage() {
return 5.073082415425886f;
}
@Override
public int getMiningLevel() {
return 2;
}
@Override
public int getEnchantability() {
return 7;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(PeccedRoot.PECCED_DUST);
}
}