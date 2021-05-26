package fr.anatom3000.gwwhit.materials.jipna;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class JipnaSword extends SwordItem {
    public JipnaSword(ToolMaterial material) {
        super(material, 7, -1.347559386537899f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}