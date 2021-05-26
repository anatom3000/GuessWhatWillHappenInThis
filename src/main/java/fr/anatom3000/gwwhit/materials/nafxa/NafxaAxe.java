package fr.anatom3000.gwwhit.materials.nafxa;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class NafxaAxe extends AxeItem {
    public NafxaAxe(ToolMaterial material) {
        super(material, 8, 0.7446327020055903f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}