package fr.anatom3000.gwwhit.materials.uwalusq;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class UwalusqShovel extends ShovelItem {
    public UwalusqShovel(ToolMaterial material) {
        super(material, 2, 0.7020086343129744f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}