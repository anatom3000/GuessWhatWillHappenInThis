package fr.anatom3000.gwwhit.materials.amader;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class AmaderAxe extends AxeItem {
    public AmaderAxe(ToolMaterial material) {
        super(material, 5, 0.8167527922661645f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}