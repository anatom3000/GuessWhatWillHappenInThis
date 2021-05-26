package fr.anatom3000.gwwhit.materials.izymam;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class IzymamMaterial implements ToolMaterial {
    public static final IzymamMaterial INSTANCE = new IzymamMaterial();

    @Override
    public int getDurability() {
        return 400;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 15.346591621241366f;
    }

    @Override
    public float getAttackDamage() {
        return 1.1504752077111158f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 23;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(IzymamRoot.IZYMAM_INGOT);
    }
}