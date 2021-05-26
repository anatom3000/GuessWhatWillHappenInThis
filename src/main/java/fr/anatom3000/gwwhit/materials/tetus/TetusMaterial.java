package fr.anatom3000.gwwhit.materials.tetus;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TetusMaterial implements ToolMaterial {
    public static final TetusMaterial INSTANCE = new TetusMaterial();

    @Override
    public int getDurability() {
        return 253;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.140026873539348f;
    }

    @Override
    public float getAttackDamage() {
        return 5.490065173980229f;
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
        return Ingredient.ofItems(TetusRoot.TETUS);
    }
}