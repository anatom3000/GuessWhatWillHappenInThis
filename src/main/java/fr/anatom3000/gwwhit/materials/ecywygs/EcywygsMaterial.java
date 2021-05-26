package fr.anatom3000.gwwhit.materials.ecywygs;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EcywygsMaterial implements ToolMaterial {
    public static final EcywygsMaterial INSTANCE = new EcywygsMaterial();

    @Override
    public int getDurability() {
        return 2032;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.0446032140766945f;
    }

    @Override
    public float getAttackDamage() {
        return 7.361528024280839f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EcywygsRoot.ECYWYGS);
    }
}