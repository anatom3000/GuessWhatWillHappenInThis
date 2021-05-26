package fr.anatom3000.gwwhit.materials.mejesh;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MejeshMaterial implements ToolMaterial {
    public static final MejeshMaterial INSTANCE = new MejeshMaterial();

    @Override
    public int getDurability() {
        return 1379;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.477874072562985f;
    }

    @Override
    public float getAttackDamage() {
        return 2.247060047710853f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 11;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MejeshRoot.MEJESH);
    }
}