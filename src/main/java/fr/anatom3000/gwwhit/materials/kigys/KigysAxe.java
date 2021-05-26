package fr.anatom3000.gwwhit.materials.kigys;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class KigysAxe extends AxeItem {
    public KigysAxe(ToolMaterial material) {
        super(material, 3, -0.40782676596208534f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}