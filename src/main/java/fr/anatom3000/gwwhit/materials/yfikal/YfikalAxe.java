package fr.anatom3000.gwwhit.materials.yfikal;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class YfikalAxe extends AxeItem {
    public YfikalAxe(ToolMaterial material) {
        super(material, 7, 0.5920628956374961f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}