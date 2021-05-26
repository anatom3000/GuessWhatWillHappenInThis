package fr.anatom3000.gwwhit.materials.fucox;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class FucoxShovel extends ShovelItem {
    public FucoxShovel(ToolMaterial material) {
        super(material, 5, -1.5088036346100115f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}