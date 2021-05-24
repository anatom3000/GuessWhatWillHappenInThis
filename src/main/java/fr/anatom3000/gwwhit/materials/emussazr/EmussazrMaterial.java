package fr.anatom3000.gwwhit.materials.emussazr;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
public class EmussazrMaterial implements ToolMaterial {
public static final EmussazrMaterial INSTANCE = new EmussazrMaterial();

@Override
public int getDurability() {
return 555;
}
@Override
public float getMiningSpeedMultiplier() {
return 7.797338711138556f;
}
@Override
public float getAttackDamage() {
return 1.5165454544476822f;
}
@Override
public int getMiningLevel() {
return 5;
}
@Override
public int getEnchantability() {
return 22;
}
@Override
public Ingredient getRepairIngredient() {
return Ingredient.ofItems(EmussazrRoot.EMUSSAZR_INGOT);
}
}