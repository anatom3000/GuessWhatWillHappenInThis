package fr.anatom3000.gwwhit.materials.emogy;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class EmogySword extends SwordItem {
    public EmogySword(ToolMaterial material) {
        super(material, 13, -0.18309598798245008f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}