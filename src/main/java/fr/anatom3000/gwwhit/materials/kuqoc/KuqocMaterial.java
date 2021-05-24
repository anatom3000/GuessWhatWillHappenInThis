package fr.anatom3000.gwwhit.materials.kuqoc;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class KuqocMaterial implements ToolMaterial {
public static final KuqocMaterial INSTANCE = new KuqocMaterial();

@Override
public int getDurability() {
return 1476;
}
@Override
public float getMiningSpeedMultiplier() {
return 7.353312039542158f;
}
@Override
public float getAttackDamage() {
return 2.8786515019564223f;
}
@Override
public int getMiningLevel() {
return 2;
}
@Override
public int getEnchantability() {
return 25;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(KuqocRoot.KUQOC_DUST);
}
}