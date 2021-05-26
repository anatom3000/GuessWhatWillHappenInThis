package fr.anatom3000.gwwhit.materials.mudatb;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class MudatbHoe extends HoeItem {
    public MudatbHoe(ToolMaterial material) {
        super(material, 6, -0.5471552532125652f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}