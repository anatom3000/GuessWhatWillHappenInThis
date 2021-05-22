package fr.anatom3000.gwwhit.materials.iqecoln;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class IqecolnMaterial implements ToolMaterial {
public static final IqecolnMaterial INSTANCE = new IqecolnMaterial();

@Override
public int getDurability() {
return 1022;
}
@Override
public float getMiningSpeedMultiplier() {
return 10.742207128957245f;
}
@Override
public float getAttackDamage() {
return 4.539433809225045f;
}
@Override
public int getMiningLevel() {
return 3;
}
@Override
public int getEnchantability() {
return 6;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(IqecolnRoot.IQECOLN_INGOT);
}
}