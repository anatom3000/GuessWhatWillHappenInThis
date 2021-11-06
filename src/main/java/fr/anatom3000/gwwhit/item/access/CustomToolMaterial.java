package fr.anatom3000.gwwhit.item.access;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public record CustomToolMaterial(float attackDamage,
                                 int durability,
                                 int enchantibility,
                                 int miningLevel,
                                 float miningSpeedMultiplier,
                                 Item repairMaterial) implements ToolMaterial {

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public int getEnchantability() {
        return enchantibility;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(repairMaterial);
    }
}
