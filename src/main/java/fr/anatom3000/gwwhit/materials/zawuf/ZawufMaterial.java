package fr.anatom3000.gwwhit.materials.zawuf;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ZawufMaterial implements ToolMaterial {
    public static final ZawufMaterial INSTANCE = new ZawufMaterial();

    @Override
    public int getDurability() {
        return 771;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.569320650236872f;
    }

    @Override
    public float getAttackDamage() {
        return 8.299466120040316f;
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
        return Ingredient.ofItems(ZawufRoot.ZAWUF);
    }
}