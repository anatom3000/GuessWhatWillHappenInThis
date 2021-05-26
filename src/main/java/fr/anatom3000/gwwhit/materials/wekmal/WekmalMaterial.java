package fr.anatom3000.gwwhit.materials.wekmal;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class WekmalMaterial implements ToolMaterial {
    public static final WekmalMaterial INSTANCE = new WekmalMaterial();

    @Override
    public int getDurability() {
        return 1606;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.5319358920491f;
    }

    @Override
    public float getAttackDamage() {
        return 4.232764543485132f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 11;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(WekmalRoot.WEKMAL_DUST);
    }
}