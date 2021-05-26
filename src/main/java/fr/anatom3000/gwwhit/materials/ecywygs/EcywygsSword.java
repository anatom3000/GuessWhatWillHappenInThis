package fr.anatom3000.gwwhit.materials.ecywygs;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class EcywygsSword extends SwordItem {
    public EcywygsSword(ToolMaterial material) {
        super(material, 9, -0.14098781943709393f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}