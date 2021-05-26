package fr.anatom3000.gwwhit.materials.zawuf;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ZawufShovel extends ShovelItem {
    public ZawufShovel(ToolMaterial material) {
        super(material, 3, 0.7553020598402027f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}