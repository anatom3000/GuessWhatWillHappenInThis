package fr.anatom3000.gwwhit.materials.hugom;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class HugomMaterial implements ToolMaterial {
public static final HugomMaterial INSTANCE = new HugomMaterial();

@Override
public int getDurability() {
return 907;
}
@Override
public float getMiningSpeedMultiplier() {
return 11.65904557455348f;
}
@Override
public float getAttackDamage() {
return 5.859582017497692f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 16;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(HugomRoot.HUGOM_DUST);
}
}