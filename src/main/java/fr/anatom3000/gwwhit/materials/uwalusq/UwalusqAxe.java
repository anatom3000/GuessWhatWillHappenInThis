package fr.anatom3000.gwwhit.materials.uwalusq;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class UwalusqAxe extends AxeItem {
    public UwalusqAxe(ToolMaterial material) {
        super(material, 4, 0.4964648378313481f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}