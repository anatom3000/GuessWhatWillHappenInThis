package fr.anatom3000.gwwhit.materials.lezdor;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LezdorMaterial implements ToolMaterial {
    public static final LezdorMaterial INSTANCE = new LezdorMaterial();

    @Override
    public int getDurability() {
        return 1266;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 14.012474139448154f;
    }

    @Override
    public float getAttackDamage() {
        return 3.3526429341617563f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 23;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(LezdorRoot.LEZDOR_DUST);
    }
}