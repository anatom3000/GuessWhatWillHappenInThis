package fr.anatom3000.gwwhit.materials.baqi;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class BaqiMaterial implements ToolMaterial {
public static final BaqiMaterial INSTANCE = new BaqiMaterial();

@Override
public int getDurability() {
return 629;
}
@Override
public float getMiningSpeedMultiplier() {
return 2.577386643494248f;
}
@Override
public float getAttackDamage() {
return 4.448162601963927f;
}
@Override
public int getMiningLevel() {
return 4;
}
@Override
public int getEnchantability() {
return 7;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(BaqiRoot.BAQI_DUST);
}
}