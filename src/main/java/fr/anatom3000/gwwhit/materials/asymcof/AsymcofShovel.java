package fr.anatom3000.gwwhit.materials.asymcof;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class AsymcofShovel extends ShovelItem {
    public AsymcofShovel(ToolMaterial material) {
        super(material, 7, -1.1497669079032438f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}