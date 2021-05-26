package fr.anatom3000.gwwhit.materials.dytap;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class DytapHoe extends HoeItem {
    public DytapHoe(ToolMaterial material) {
        super(material, 1, 0.4718786912907078f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}