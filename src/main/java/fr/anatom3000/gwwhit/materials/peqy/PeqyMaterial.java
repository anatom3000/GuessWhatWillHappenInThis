package fr.anatom3000.gwwhit.materials.peqy;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PeqyMaterial implements ToolMaterial {
    public static final PeqyMaterial INSTANCE = new PeqyMaterial();

    @Override
    public int getDurability() {
        return 1161;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.375657494679764f;
    }

    @Override
    public float getAttackDamage() {
        return 6.786130434522461f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(PeqyRoot.PEQY);
    }
}