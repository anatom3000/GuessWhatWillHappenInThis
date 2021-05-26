package fr.anatom3000.gwwhit.materials.obuxan;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ObuxanMaterial implements ToolMaterial {
    public static final ObuxanMaterial INSTANCE = new ObuxanMaterial();

    @Override
    public int getDurability() {
        return 434;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.393724948675212f;
    }

    @Override
    public float getAttackDamage() {
        return 6.771001189480096f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 23;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ObuxanRoot.OBUXAN_INGOT);
    }
}