package fr.anatom3000.gwwhit.materials.iqecoln;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class IqecolnSword extends SwordItem {
    public IqecolnSword(ToolMaterial material) {
        super(material, 5, -1.0702985943434138f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}