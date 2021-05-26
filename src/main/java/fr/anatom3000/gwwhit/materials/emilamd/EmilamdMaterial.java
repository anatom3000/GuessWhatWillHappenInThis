package fr.anatom3000.gwwhit.materials.emilamd;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EmilamdMaterial implements ToolMaterial {
    public static final EmilamdMaterial INSTANCE = new EmilamdMaterial();

    @Override
    public int getDurability() {
        return 1401;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 3.6906235243402854f;
    }

    @Override
    public float getAttackDamage() {
        return 8.472699849340703f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 7;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EmilamdRoot.EMILAMD_INGOT);
    }
}