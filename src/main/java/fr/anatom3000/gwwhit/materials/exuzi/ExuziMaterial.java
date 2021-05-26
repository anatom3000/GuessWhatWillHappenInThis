package fr.anatom3000.gwwhit.materials.exuzi;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ExuziMaterial implements ToolMaterial {
    public static final ExuziMaterial INSTANCE = new ExuziMaterial();

    @Override
    public int getDurability() {
        return 707;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.203166278952576f;
    }

    @Override
    public float getAttackDamage() {
        return 1.0680627208270088f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ExuziRoot.EXUZI_INGOT);
    }
}