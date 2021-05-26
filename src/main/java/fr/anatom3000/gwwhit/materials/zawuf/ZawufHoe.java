package fr.anatom3000.gwwhit.materials.zawuf;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class ZawufHoe extends HoeItem {
    public ZawufHoe(ToolMaterial material) {
        super(material, 8, -1.6670343427988783f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}