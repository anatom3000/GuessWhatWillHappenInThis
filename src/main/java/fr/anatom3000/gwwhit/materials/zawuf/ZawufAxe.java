package fr.anatom3000.gwwhit.materials.zawuf;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class ZawufAxe extends AxeItem {
    public ZawufAxe(ToolMaterial material) {
        super(material, 6, 0.10292572576133208f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}