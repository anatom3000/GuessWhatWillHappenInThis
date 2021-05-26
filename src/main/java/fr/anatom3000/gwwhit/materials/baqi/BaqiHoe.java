package fr.anatom3000.gwwhit.materials.baqi;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class BaqiHoe extends HoeItem {
    public BaqiHoe(ToolMaterial material) {
        super(material, 7, -0.0028906791828311462f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}