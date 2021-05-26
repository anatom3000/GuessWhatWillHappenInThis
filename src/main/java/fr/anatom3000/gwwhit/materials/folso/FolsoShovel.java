package fr.anatom3000.gwwhit.materials.folso;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class FolsoShovel extends ShovelItem {
    public FolsoShovel(ToolMaterial material) {
        super(material, 1, 0.3879579509864943f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}