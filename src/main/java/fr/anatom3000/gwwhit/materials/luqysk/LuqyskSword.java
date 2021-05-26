package fr.anatom3000.gwwhit.materials.luqysk;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class LuqyskSword extends SwordItem {
    public LuqyskSword(ToolMaterial material) {
        super(material, 12, -0.7960499844934699f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}