package fr.anatom3000.gwwhit.materials.kuzidb;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class KuzidbSword extends SwordItem {
    public KuzidbSword(ToolMaterial material) {
        super(material, 5, -1.1437348380314147f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}