package fr.anatom3000.gwwhit.materials.nefyf;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class NefyfMaterial implements ToolMaterial {
    public static final NefyfMaterial INSTANCE = new NefyfMaterial();

    @Override
    public int getDurability() {
        return 1763;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.595970375120269f;
    }

    @Override
    public float getAttackDamage() {
        return 7.682380451883886f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(NefyfRoot.NEFYF);
    }
}