package fr.anatom3000.gwwhit.materials.obuxan;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class ObuxanAxe extends AxeItem {
    public ObuxanAxe(ToolMaterial material) {
        super(material, 7, -1.6527819649081965f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}