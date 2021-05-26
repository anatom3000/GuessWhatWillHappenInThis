package fr.anatom3000.gwwhit.materials.folso;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FolsoMaterial implements ToolMaterial {
    public static final FolsoMaterial INSTANCE = new FolsoMaterial();

    @Override
    public int getDurability() {
        return 1534;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.057433865323166f;
    }

    @Override
    public float getAttackDamage() {
        return 2.64489055135475f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(FolsoRoot.FOLSO_DUST);
    }
}