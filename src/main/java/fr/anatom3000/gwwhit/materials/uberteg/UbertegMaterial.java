package fr.anatom3000.gwwhit.materials.uberteg;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class UbertegMaterial implements ToolMaterial {
    public static final UbertegMaterial INSTANCE = new UbertegMaterial();

    @Override
    public int getDurability() {
        return 900;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.023915418162933f;
    }

    @Override
    public float getAttackDamage() {
        return 1.7238453779054188f;
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
        return Ingredient.ofItems(UbertegRoot.UBERTEG_INGOT);
    }
}