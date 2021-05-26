package fr.anatom3000.gwwhit.materials.renu;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RenuMaterial implements ToolMaterial {
    public static final RenuMaterial INSTANCE = new RenuMaterial();

    @Override
    public int getDurability() {
        return 1203;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.409508642333618f;
    }

    @Override
    public float getAttackDamage() {
        return 4.240568689050109f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RenuRoot.RENU);
    }
}