package fr.anatom3000.gwwhit.materials.icawlu;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class IcawluAxe extends AxeItem {
    public IcawluAxe(ToolMaterial material) {
        super(material, 6, 0.17490903398646518f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}