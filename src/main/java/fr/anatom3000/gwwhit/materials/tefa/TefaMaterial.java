package fr.anatom3000.gwwhit.materials.tefa;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TefaMaterial implements ToolMaterial {
    public static final TefaMaterial INSTANCE = new TefaMaterial();

    @Override
    public int getDurability() {
        return 1272;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.25145046597636f;
    }

    @Override
    public float getAttackDamage() {
        return 3.451599387126397f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TefaRoot.TEFA_DUST);
    }
}