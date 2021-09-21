package fr.anatom3000.gwwhit.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MalekToolMaterial implements ToolMaterial {
    public static final MalekToolMaterial INSTANCE = new MalekToolMaterial();
    @Override
    public int getDurability() {
        return 50;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1000;
    }

    @Override
    public float getAttackDamage() {
        return 15;
    }

    @Override
    public int getMiningLevel() {
        return 100000;
    }

    @Override
    public int getEnchantability() {
        return -1;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.OAK_LOG);
    }
}
