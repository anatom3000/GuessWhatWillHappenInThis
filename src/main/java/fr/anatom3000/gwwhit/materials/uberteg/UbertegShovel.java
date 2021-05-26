package fr.anatom3000.gwwhit.materials.uberteg;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class UbertegShovel extends ShovelItem {
    public UbertegShovel(ToolMaterial material) {
        super(material, 3, -1.1915052158418922f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}