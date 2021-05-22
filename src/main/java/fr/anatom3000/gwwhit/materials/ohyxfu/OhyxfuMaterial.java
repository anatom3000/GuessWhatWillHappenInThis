package fr.anatom3000.gwwhit.materials.ohyxfu;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class OhyxfuMaterial implements ToolMaterial {
public static final OhyxfuMaterial INSTANCE = new OhyxfuMaterial();

@Override
public int getDurability() {
return 107;
}
@Override
public float getMiningSpeedMultiplier() {
return 10.614209286897276f;
}
@Override
public float getAttackDamage() {
return 2.3472499434504956f;
}
@Override
public int getMiningLevel() {
return 2;
}
@Override
public int getEnchantability() {
return 12;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(OhyxfuRoot.OHYXFU_INGOT);
}
}