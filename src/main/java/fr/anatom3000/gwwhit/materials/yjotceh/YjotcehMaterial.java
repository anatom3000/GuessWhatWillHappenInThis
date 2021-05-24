package fr.anatom3000.gwwhit.materials.yjotceh;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class YjotcehMaterial implements ToolMaterial {
public static final YjotcehMaterial INSTANCE = new YjotcehMaterial();

@Override
public int getDurability() {
return 1488;
}
@Override
public float getMiningSpeedMultiplier() {
return 2.532275682434933f;
}
@Override
public float getAttackDamage() {
return 2.0156040632151404f;
}
@Override
public int getMiningLevel() {
return 2;
}
@Override
public int getEnchantability() {
return 19;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(YjotcehRoot.YJOTCEH_INGOT);
}
}