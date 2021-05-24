package fr.anatom3000.gwwhit.materials.fydif;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class FydifMaterial implements ToolMaterial {
public static final FydifMaterial INSTANCE = new FydifMaterial();

@Override
public int getDurability() {
return 629;
}
@Override
public float getMiningSpeedMultiplier() {
return 14.126780556703991f;
}
@Override
public float getAttackDamage() {
return 3.6634857444404303f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 11;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(FydifRoot.FYDIF);
}
}