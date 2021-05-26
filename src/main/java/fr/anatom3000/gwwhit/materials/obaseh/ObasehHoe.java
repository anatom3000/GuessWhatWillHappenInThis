package fr.anatom3000.gwwhit.materials.obaseh;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class ObasehHoe extends HoeItem {
    public ObasehHoe(ToolMaterial material) {
        super(material, 1, -1.7180485421307528f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}