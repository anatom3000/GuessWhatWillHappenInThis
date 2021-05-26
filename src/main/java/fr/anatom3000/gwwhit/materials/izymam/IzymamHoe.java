package fr.anatom3000.gwwhit.materials.izymam;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class IzymamHoe extends HoeItem {
    public IzymamHoe(ToolMaterial material) {
        super(material, 7, -1.2649152061457936f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}