package fr.anatom3000.gwwhit.materials.gycu;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class GycuMaterial implements ToolMaterial {
public static final GycuMaterial INSTANCE = new GycuMaterial();

@Override
public int getDurability() {
return 1113;
}
@Override
public float getMiningSpeedMultiplier() {
return 12.23688318546601f;
}
@Override
public float getAttackDamage() {
return 8.349518929683697f;
}
@Override
public int getMiningLevel() {
return 4;
}
@Override
public int getEnchantability() {
return 11;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(GycuRoot.GYCU);
}
}