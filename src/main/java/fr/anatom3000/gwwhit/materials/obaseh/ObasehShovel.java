package fr.anatom3000.gwwhit.materials.obaseh;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ObasehShovel extends ShovelItem {
    public ObasehShovel(ToolMaterial material) {
        super(material, 6, -1.8570904719113885f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}