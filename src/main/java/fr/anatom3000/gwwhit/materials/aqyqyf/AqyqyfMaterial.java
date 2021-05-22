package fr.anatom3000.gwwhit.materials.aqyqyf;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class AqyqyfMaterial implements ToolMaterial {
public static final AqyqyfMaterial INSTANCE = new AqyqyfMaterial();

@Override
public int getDurability() {
return 2025;
}
@Override
public float getMiningSpeedMultiplier() {
return 6.790453193044719f;
}
@Override
public float getAttackDamage() {
return 3.7660888434942175f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 20;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(AqyqyfRoot.AQYQYF_INGOT);
}
}