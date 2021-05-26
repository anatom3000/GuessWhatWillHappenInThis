package fr.anatom3000.gwwhit.materials.sijtyw;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SijtywMaterial implements ToolMaterial {
    public static final SijtywMaterial INSTANCE = new SijtywMaterial();

    @Override
    public int getDurability() {
        return 1344;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.6412413876857475f;
    }

    @Override
    public float getAttackDamage() {
        return 3.196525899446498f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 24;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(SijtywRoot.SIJTYW);
    }
}