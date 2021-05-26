package fr.anatom3000.gwwhit.materials.fyfat;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class FyfatAxe extends AxeItem {
    public FyfatAxe(ToolMaterial material) {
        super(material, 3, -0.6099038515342914f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}