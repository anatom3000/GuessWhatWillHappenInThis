package fr.anatom3000.gwwhit.materials.foqepm;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class FoqepmShovel extends ShovelItem {
    public FoqepmShovel(ToolMaterial material) {
        super(material, 6, -1.66097450621485f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}