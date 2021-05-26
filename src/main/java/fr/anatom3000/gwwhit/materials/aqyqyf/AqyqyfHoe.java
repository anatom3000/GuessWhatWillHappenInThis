package fr.anatom3000.gwwhit.materials.aqyqyf;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class AqyqyfHoe extends HoeItem {
    public AqyqyfHoe(ToolMaterial material) {
        super(material, 8, -1.718557875902969f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}