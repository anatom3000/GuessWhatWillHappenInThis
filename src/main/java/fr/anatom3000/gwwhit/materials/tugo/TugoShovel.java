package fr.anatom3000.gwwhit.materials.tugo;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class TugoShovel extends ShovelItem {
    public TugoShovel(ToolMaterial material) {
        super(material, 2, 0.15919833951809137f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}