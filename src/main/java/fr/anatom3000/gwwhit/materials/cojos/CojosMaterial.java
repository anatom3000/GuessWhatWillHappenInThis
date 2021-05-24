package fr.anatom3000.gwwhit.materials.cojos;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class CojosMaterial implements ToolMaterial {
public static final CojosMaterial INSTANCE = new CojosMaterial();

@Override
public int getDurability() {
return 1297;
}
@Override
public float getMiningSpeedMultiplier() {
return 15.017479206622793f;
}
@Override
public float getAttackDamage() {
return 8.150013191384598f;
}
@Override
public int getMiningLevel() {
return 2;
}
@Override
public int getEnchantability() {
return 5;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(CojosRoot.COJOS);
}
}