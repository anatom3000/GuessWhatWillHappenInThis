package fr.anatom3000.gwwhit.materials.ijyqbag;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class IjyqbagMaterial implements ToolMaterial {
public static final IjyqbagMaterial INSTANCE = new IjyqbagMaterial();

@Override
public int getDurability() {
return 1402;
}
@Override
public float getMiningSpeedMultiplier() {
return 12.241198151780395f;
}
@Override
public float getAttackDamage() {
return 3.7148528211851355f;
}
@Override
public int getMiningLevel() {
return 4;
}
@Override
public int getEnchantability() {
return 24;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(IjyqbagRoot.IJYQBAG_INGOT);
}
}