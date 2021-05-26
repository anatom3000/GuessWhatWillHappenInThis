package fr.anatom3000.gwwhit.materials.yqubef;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class YqubefSword extends SwordItem {
    public YqubefSword(ToolMaterial material) {
        super(material, 15, -0.8305823401207597f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}