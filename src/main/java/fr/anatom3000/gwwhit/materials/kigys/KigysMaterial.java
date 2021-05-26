package fr.anatom3000.gwwhit.materials.kigys;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class KigysMaterial implements ToolMaterial {
    public static final KigysMaterial INSTANCE = new KigysMaterial();

    @Override
    public int getDurability() {
        return 1194;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.580743714515104f;
    }

    @Override
    public float getAttackDamage() {
        return 5.313132433964744f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 24;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(KigysRoot.KIGYS);
    }
}