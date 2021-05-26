package fr.anatom3000.gwwhit.materials.ebeqir;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EbeqirMaterial implements ToolMaterial {
    public static final EbeqirMaterial INSTANCE = new EbeqirMaterial();

    @Override
    public int getDurability() {
        return 1430;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.6010958042025596f;
    }

    @Override
    public float getAttackDamage() {
        return 7.968093360634861f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EbeqirRoot.EBEQIR);
    }
}