package fr.anatom3000.gwwhit.materials.yjosok;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class YjosokMaterial implements ToolMaterial {
    public static final YjosokMaterial INSTANCE = new YjosokMaterial();

    @Override
    public int getDurability() {
        return 1772;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.37834456784838f;
    }

    @Override
    public float getAttackDamage() {
        return 1.8194727121471548f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(YjosokRoot.YJOSOK_INGOT);
    }
}