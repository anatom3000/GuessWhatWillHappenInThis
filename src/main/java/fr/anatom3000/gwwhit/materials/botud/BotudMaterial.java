package fr.anatom3000.gwwhit.materials.botud;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BotudMaterial implements ToolMaterial {
    public static final BotudMaterial INSTANCE = new BotudMaterial();

    @Override
    public int getDurability() {
        return 1090;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.558458071087134f;
    }

    @Override
    public float getAttackDamage() {
        return 2.6254678284148416f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 21;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(BotudRoot.BOTUD);
    }
}