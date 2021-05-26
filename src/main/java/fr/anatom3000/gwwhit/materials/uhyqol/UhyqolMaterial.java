package fr.anatom3000.gwwhit.materials.uhyqol;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class UhyqolMaterial implements ToolMaterial {
    public static final UhyqolMaterial INSTANCE = new UhyqolMaterial();

    @Override
    public int getDurability() {
        return 1326;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.3922786685828f;
    }

    @Override
    public float getAttackDamage() {
        return 1.749637352354888f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 23;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(UhyqolRoot.UHYQOL_INGOT);
    }
}