package fr.anatom3000.gwwhit.materials.tugo;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TugoMaterial implements ToolMaterial {
    public static final TugoMaterial INSTANCE = new TugoMaterial();

    @Override
    public int getDurability() {
        return 1912;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 3.546170414653135f;
    }

    @Override
    public float getAttackDamage() {
        return 3.0206601356410787f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 23;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TugoRoot.TUGO);
    }
}