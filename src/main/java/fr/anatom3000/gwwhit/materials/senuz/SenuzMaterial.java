package fr.anatom3000.gwwhit.materials.senuz;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SenuzMaterial implements ToolMaterial {
    public static final SenuzMaterial INSTANCE = new SenuzMaterial();

    @Override
    public int getDurability() {
        return 129;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.959745273464765f;
    }

    @Override
    public float getAttackDamage() {
        return 6.3115542832640035f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 8;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(SenuzRoot.SENUZ_DUST);
    }
}