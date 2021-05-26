package fr.anatom3000.gwwhit.materials.igekez;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class IgekezMaterial implements ToolMaterial {
    public static final IgekezMaterial INSTANCE = new IgekezMaterial();

    @Override
    public int getDurability() {
        return 1817;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.23866100789806f;
    }

    @Override
    public float getAttackDamage() {
        return 5.815923557215183f;
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
        return Ingredient.ofItems(IgekezRoot.IGEKEZ_INGOT);
    }
}