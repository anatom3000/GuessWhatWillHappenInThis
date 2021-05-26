package fr.anatom3000.gwwhit.materials.fydif;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class FydifShovel extends ShovelItem {
    public FydifShovel(ToolMaterial material) {
        super(material, 7, -0.11453420382619539f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}