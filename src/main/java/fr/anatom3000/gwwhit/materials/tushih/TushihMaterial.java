package fr.anatom3000.gwwhit.materials.tushih;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TushihMaterial implements ToolMaterial {
    public static final TushihMaterial INSTANCE = new TushihMaterial();

    @Override
    public int getDurability() {
        return 1319;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.085079051460564f;
    }

    @Override
    public float getAttackDamage() {
        return 4.945459924430304f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TushihRoot.TUSHIH_DUST);
    }
}