package fr.anatom3000.gwwhit.materials.foqepm;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class FoqepmMaterial implements ToolMaterial {
public static final FoqepmMaterial INSTANCE = new FoqepmMaterial();

@Override
public int getDurability() {
return 1770;
}
@Override
public float getMiningSpeedMultiplier() {
return 8.390789316329016f;
}
@Override
public float getAttackDamage() {
return 3.6728027737665148f;
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
return Ingredient.ofItems(FoqepmRoot.FOQEPM);
}
}