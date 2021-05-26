package fr.anatom3000.gwwhit.materials.emilamd;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class EmilamdSword extends SwordItem {
    public EmilamdSword(ToolMaterial material) {
        super(material, 12, -0.0006179472880221137f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}