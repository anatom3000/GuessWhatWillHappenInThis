package fr.anatom3000.gwwhit.materials.luqysk;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LuqyskMaterial implements ToolMaterial {
    public static final LuqyskMaterial INSTANCE = new LuqyskMaterial();

    @Override
    public int getDurability() {
        return 637;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.74273027079909f;
    }

    @Override
    public float getAttackDamage() {
        return 7.288505200071953f;
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
        return Ingredient.ofItems(LuqyskRoot.LUQYSK);
    }
}