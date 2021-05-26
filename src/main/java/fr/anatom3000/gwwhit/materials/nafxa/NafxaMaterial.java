package fr.anatom3000.gwwhit.materials.nafxa;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class NafxaMaterial implements ToolMaterial {
    public static final NafxaMaterial INSTANCE = new NafxaMaterial();

    @Override
    public int getDurability() {
        return 1821;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.544598080345775f;
    }

    @Override
    public float getAttackDamage() {
        return 3.4717531185269452f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(NafxaRoot.NAFXA_DUST);
    }
}