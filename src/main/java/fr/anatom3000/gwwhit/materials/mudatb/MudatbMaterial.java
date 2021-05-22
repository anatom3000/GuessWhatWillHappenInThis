package fr.anatom3000.gwwhit.materials.mudatb;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class MudatbMaterial implements ToolMaterial {
public static final MudatbMaterial INSTANCE = new MudatbMaterial();

@Override
public int getDurability() {
return 1600;
}
@Override
public float getMiningSpeedMultiplier() {
return 9.364373903518596f;
}
@Override
public float getAttackDamage() {
return 3.670534678789253f;
}
@Override
public int getMiningLevel() {
return 2;
}
@Override
public int getEnchantability() {
return 23;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(MudatbRoot.MUDATB);
}
}