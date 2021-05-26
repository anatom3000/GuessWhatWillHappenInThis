package fr.anatom3000.gwwhit.materials.umaboz;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class UmabozAxe extends AxeItem {
    public UmabozAxe(ToolMaterial material) {
        super(material, 5, -1.3205778841083444f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}