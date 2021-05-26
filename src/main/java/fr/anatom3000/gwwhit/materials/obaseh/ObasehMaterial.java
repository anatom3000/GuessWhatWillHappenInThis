package fr.anatom3000.gwwhit.materials.obaseh;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ObasehMaterial implements ToolMaterial {
    public static final ObasehMaterial INSTANCE = new ObasehMaterial();

    @Override
    public int getDurability() {
        return 379;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 14.92134711342834f;
    }

    @Override
    public float getAttackDamage() {
        return 5.404793686465695f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ObasehRoot.OBASEH_INGOT);
    }
}