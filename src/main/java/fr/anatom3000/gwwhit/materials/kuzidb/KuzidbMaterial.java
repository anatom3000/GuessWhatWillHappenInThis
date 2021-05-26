package fr.anatom3000.gwwhit.materials.kuzidb;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class KuzidbMaterial implements ToolMaterial {
    public static final KuzidbMaterial INSTANCE = new KuzidbMaterial();

    @Override
    public int getDurability() {
        return 51;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.792613132848373f;
    }

    @Override
    public float getAttackDamage() {
        return 3.5536407458727717f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(KuzidbRoot.KUZIDB_DUST);
    }
}