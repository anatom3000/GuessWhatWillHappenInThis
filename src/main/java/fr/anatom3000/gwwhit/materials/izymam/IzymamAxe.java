package fr.anatom3000.gwwhit.materials.izymam;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class IzymamAxe extends AxeItem {
    public IzymamAxe(ToolMaterial material) {
        super(material, 1, 0.10192212501255804f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}