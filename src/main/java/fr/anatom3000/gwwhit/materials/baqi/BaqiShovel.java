package fr.anatom3000.gwwhit.materials.baqi;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class BaqiShovel extends ShovelItem {
    public BaqiShovel(ToolMaterial material) {
        super(material, 6, -0.5823058844041682f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}