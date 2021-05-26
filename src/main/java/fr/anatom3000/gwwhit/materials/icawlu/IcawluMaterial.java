package fr.anatom3000.gwwhit.materials.icawlu;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class IcawluMaterial implements ToolMaterial {
    public static final IcawluMaterial INSTANCE = new IcawluMaterial();

    @Override
    public int getDurability() {
        return 262;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.131049416873641f;
    }

    @Override
    public float getAttackDamage() {
        return 5.7344630980447455f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(IcawluRoot.ICAWLU_INGOT);
    }
}