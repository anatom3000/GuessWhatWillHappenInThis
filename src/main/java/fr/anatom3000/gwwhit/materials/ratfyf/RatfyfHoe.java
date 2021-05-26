package fr.anatom3000.gwwhit.materials.ratfyf;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class RatfyfHoe extends HoeItem {
    public RatfyfHoe(ToolMaterial material) {
        super(material, 4, -0.12978442031052584f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}