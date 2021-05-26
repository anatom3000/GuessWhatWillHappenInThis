package fr.anatom3000.gwwhit.materials.jipna;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class JipnaMaterial implements ToolMaterial {
    public static final JipnaMaterial INSTANCE = new JipnaMaterial();

    @Override
    public int getDurability() {
        return 193;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.313835322238852f;
    }

    @Override
    public float getAttackDamage() {
        return 6.60991361122133f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(JipnaRoot.JIPNA_DUST);
    }
}