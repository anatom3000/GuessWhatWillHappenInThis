package fr.anatom3000.gwwhit.materials.ratfyf;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class RatfyfShovel extends ShovelItem {
    public RatfyfShovel(ToolMaterial material) {
        super(material, 4, -0.6719884921707653f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}