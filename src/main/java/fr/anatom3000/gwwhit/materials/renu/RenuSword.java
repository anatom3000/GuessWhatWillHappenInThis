package fr.anatom3000.gwwhit.materials.renu;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class RenuSword extends SwordItem {
    public RenuSword(ToolMaterial material) {
        super(material, 2, -1.149871625324046f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}