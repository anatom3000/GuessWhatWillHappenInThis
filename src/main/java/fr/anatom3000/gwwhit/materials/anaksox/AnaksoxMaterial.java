package fr.anatom3000.gwwhit.materials.anaksox;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AnaksoxMaterial implements ToolMaterial {
    public static final AnaksoxMaterial INSTANCE = new AnaksoxMaterial();

    @Override
    public int getDurability() {
        return 894;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.429239902262496f;
    }

    @Override
    public float getAttackDamage() {
        return 4.434928181864005f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AnaksoxRoot.ANAKSOX_INGOT);
    }
}