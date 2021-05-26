package fr.anatom3000.gwwhit.materials.loded;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LodedMaterial implements ToolMaterial {
    public static final LodedMaterial INSTANCE = new LodedMaterial();

    @Override
    public int getDurability() {
        return 1938;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.54382597920572f;
    }

    @Override
    public float getAttackDamage() {
        return 3.145757767124865f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 7;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(LodedRoot.LODED);
    }
}