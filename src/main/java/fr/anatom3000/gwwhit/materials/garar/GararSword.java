package fr.anatom3000.gwwhit.materials.garar;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class GararSword extends SwordItem {
    public GararSword(ToolMaterial material) {
        super(material, 2, -1.929481432401432f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}