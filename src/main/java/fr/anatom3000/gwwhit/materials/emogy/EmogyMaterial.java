package fr.anatom3000.gwwhit.materials.emogy;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class EmogyMaterial implements ToolMaterial {
public static final EmogyMaterial INSTANCE = new EmogyMaterial();

@Override
public int getDurability() {
return 118;
}
@Override
public float getMiningSpeedMultiplier() {
return 11.824308146062595f;
}
@Override
public float getAttackDamage() {
return 1.6675187873287267f;
}
@Override
public int getMiningLevel() {
return 4;
}
@Override
public int getEnchantability() {
return 8;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(EmogyRoot.EMOGY_INGOT);
}
}