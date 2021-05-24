package fr.anatom3000.gwwhit.materials.yqubef;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class YqubefMaterial implements ToolMaterial {
public static final YqubefMaterial INSTANCE = new YqubefMaterial();

@Override
public int getDurability() {
return 732;
}
@Override
public float getMiningSpeedMultiplier() {
return 12.647216771906516f;
}
@Override
public float getAttackDamage() {
return 4.746380986658027f;
}
@Override
public int getMiningLevel() {
return 3;
}
@Override
public int getEnchantability() {
return 18;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(YqubefRoot.YQUBEF);
}
}