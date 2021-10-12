package fr.anatom3000.gwwhit.item.access;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class CustomShovel extends ShovelItem {
    public CustomShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
