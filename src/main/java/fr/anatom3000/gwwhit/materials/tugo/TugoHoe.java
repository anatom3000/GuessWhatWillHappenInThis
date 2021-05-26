package fr.anatom3000.gwwhit.materials.tugo;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class TugoHoe extends HoeItem {
    public TugoHoe(ToolMaterial material) {
        super(material, 1, -1.9742980739009024f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}