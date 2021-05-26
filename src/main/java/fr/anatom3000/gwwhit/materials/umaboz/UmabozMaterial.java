package fr.anatom3000.gwwhit.materials.umaboz;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class UmabozMaterial implements ToolMaterial {
    public static final UmabozMaterial INSTANCE = new UmabozMaterial();

    @Override
    public int getDurability() {
        return 885;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1.5110912532139869f;
    }

    @Override
    public float getAttackDamage() {
        return 4.222950345968764f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(UmabozRoot.UMABOZ_INGOT);
    }
}