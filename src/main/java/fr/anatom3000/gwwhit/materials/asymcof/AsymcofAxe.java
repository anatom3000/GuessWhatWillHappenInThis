package fr.anatom3000.gwwhit.materials.asymcof;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class AsymcofAxe extends AxeItem {
    public AsymcofAxe(ToolMaterial material) {
        super(material, 7, -0.8150647183700435f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}