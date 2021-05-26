package fr.anatom3000.gwwhit.materials.gigyh;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class GigyhMaterial implements ToolMaterial {
    public static final GigyhMaterial INSTANCE = new GigyhMaterial();

    @Override
    public int getDurability() {
        return 1034;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.44883440661037f;
    }

    @Override
    public float getAttackDamage() {
        return 3.6715425965716504f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(GigyhRoot.GIGYH);
    }
}