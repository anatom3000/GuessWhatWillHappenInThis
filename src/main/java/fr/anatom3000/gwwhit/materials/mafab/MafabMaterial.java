package fr.anatom3000.gwwhit.materials.mafab;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class MafabMaterial implements ToolMaterial {
public static final MafabMaterial INSTANCE = new MafabMaterial();

@Override
public int getDurability() {
return 1943;
}
@Override
public float getMiningSpeedMultiplier() {
return 8.718019017969528f;
}
@Override
public float getAttackDamage() {
return 2.009675122654598f;
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
return Ingredient.ofItems(MafabRoot.MAFAB);
}
}