package fr.anatom3000.gwwhit.item.access;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class CustomHoeItem extends HoeItem {
    public CustomHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
