package fr.anatom3000.gwwhit.materials.tetus;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class TetusSword extends SwordItem {
    public TetusSword(ToolMaterial material) {
        super(material, 13, -1.5987746040331299f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}