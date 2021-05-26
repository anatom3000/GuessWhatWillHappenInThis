package fr.anatom3000.gwwhit.materials.ikaqajc;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class IkaqajcSword extends SwordItem {
    public IkaqajcSword(ToolMaterial material) {
        super(material, 15, 0.4872878328843332f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}