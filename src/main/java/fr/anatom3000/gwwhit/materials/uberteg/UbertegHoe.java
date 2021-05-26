package fr.anatom3000.gwwhit.materials.uberteg;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class UbertegHoe extends HoeItem {
    public UbertegHoe(ToolMaterial material) {
        super(material, 6, -1.8434704529331079f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}