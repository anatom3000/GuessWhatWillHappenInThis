package fr.anatom3000.gwwhit.materials.kigys;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class KigysHoe extends HoeItem {
    public KigysHoe(ToolMaterial material) {
        super(material, 1, -1.0950456929086707f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}