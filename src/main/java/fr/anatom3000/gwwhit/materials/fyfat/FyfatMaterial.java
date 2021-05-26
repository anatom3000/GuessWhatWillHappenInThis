package fr.anatom3000.gwwhit.materials.fyfat;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FyfatMaterial implements ToolMaterial {
    public static final FyfatMaterial INSTANCE = new FyfatMaterial();

    @Override
    public int getDurability() {
        return 285;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.679278580054987f;
    }

    @Override
    public float getAttackDamage() {
        return 3.824070423914125f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 21;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(FyfatRoot.FYFAT);
    }
}