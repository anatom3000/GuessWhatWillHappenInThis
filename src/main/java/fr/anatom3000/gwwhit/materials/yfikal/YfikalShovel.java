package fr.anatom3000.gwwhit.materials.yfikal;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class YfikalShovel extends ShovelItem {
    public YfikalShovel(ToolMaterial material) {
        super(material, 5, -0.49832612146023614f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}