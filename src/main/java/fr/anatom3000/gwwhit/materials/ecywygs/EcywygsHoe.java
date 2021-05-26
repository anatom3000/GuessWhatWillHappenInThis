package fr.anatom3000.gwwhit.materials.ecywygs;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class EcywygsHoe extends HoeItem {
    public EcywygsHoe(ToolMaterial material) {
        super(material, 4, -1.7812265074881095f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}