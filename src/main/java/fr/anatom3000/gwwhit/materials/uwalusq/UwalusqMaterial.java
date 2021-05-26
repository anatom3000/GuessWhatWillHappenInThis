package fr.anatom3000.gwwhit.materials.uwalusq;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class UwalusqMaterial implements ToolMaterial {
    public static final UwalusqMaterial INSTANCE = new UwalusqMaterial();

    @Override
    public int getDurability() {
        return 1897;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.9548067877268918f;
    }

    @Override
    public float getAttackDamage() {
        return 2.4779019871319496f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(UwalusqRoot.UWALUSQ_INGOT);
    }
}