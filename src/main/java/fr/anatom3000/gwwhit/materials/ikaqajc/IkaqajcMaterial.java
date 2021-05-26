package fr.anatom3000.gwwhit.materials.ikaqajc;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class IkaqajcMaterial implements ToolMaterial {
    public static final IkaqajcMaterial INSTANCE = new IkaqajcMaterial();

    @Override
    public int getDurability() {
        return 337;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.359530297243529f;
    }

    @Override
    public float getAttackDamage() {
        return 6.657547625555814f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(IkaqajcRoot.IKAQAJC);
    }
}