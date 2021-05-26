package fr.anatom3000.gwwhit.materials.cojos;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class CojosShovel extends ShovelItem {
    public CojosShovel(ToolMaterial material) {
        super(material, 5, -1.9483550576214608f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}