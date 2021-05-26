package fr.anatom3000.gwwhit.materials.dytap;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class DytapShovel extends ShovelItem {
    public DytapShovel(ToolMaterial material) {
        super(material, 1, -0.8263533584014666f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}